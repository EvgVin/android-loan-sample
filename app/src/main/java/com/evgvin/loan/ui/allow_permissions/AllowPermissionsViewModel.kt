package com.evgvin.loan.ui.allow_permissions

import android.content.Context
import android.location.Location
import android.location.LocationManager
import android.net.Uri
import android.provider.ContactsContract
import com.evgvin.loan.R
import com.evgvin.loan.data.model.Contact
import com.evgvin.loan.data.model.Sms
import com.evgvin.loan.data.model.UserPrivateInfo
import com.evgvin.loan.data.repository.UserPrivateInfoRepository
import com.evgvin.loan.ui.base.BaseViewModel
import com.evgvin.loan.ui.common.SingleLiveEvent
import com.evgvin.loan.util.getData
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class AllowPermissionsViewModel @Inject constructor(
    private val context: Context,
    private val userPrivateInfoRepository: UserPrivateInfoRepository
) : BaseViewModel() {

    val allowAccessEvent = SingleLiveEvent<Void>()
    val learnMoreEvent = SingleLiveEvent<Void>()
    val userPrivateInfoSavedEvent = SingleLiveEvent<Void>()
    val snackbarMessage = SingleLiveEvent<String>()

    fun onAllowAccessClick() {
        allowAccessEvent.call()
    }

    fun onLearnMoreClick() {
        learnMoreEvent.call()
    }

    /**
     * Sends all required information about the user on server.
     */
    fun sendUserInformation() {
        compositeDisposable += Observable
            .create<UserPrivateInfo> { emitter ->
                val sms = getInboxSms()
                val contacts = getContacts()
                val location = getLocation()

                val userPrivateInfo = UserPrivateInfo(sms, contacts, location)

                emitter.onNext(userPrivateInfo)
                emitter.onComplete()

            }
            .subscribeOn(Schedulers.io())
            .flatMap { userPrivateInfoRepository.sendUserPrivateInfo(it) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                userPrivateInfoSavedEvent.call()
            }, {
                snackbarMessage.value = context.getString(R.string.languages_error)
            })
    }

    /**
     * Gets all SMS from inbox.
     */
    private fun getInboxSms(): List<Sms> {
        return context.contentResolver.getData(Uri.parse("content://sms/inbox")) {
            Sms(
                it.getString(it.getColumnIndexOrThrow("address")),
                it.getString(it.getColumnIndexOrThrow("body"))
            )
        }
    }

    /**
     * Gets all contacts.
     */
    private fun getContacts(): List<Contact> {
        return context.contentResolver.getData(ContactsContract.Contacts.CONTENT_URI) {
            val id = it.getString(it.getColumnIndex(ContactsContract.Contacts._ID))
            var phones: List<String>? = null
            if (it.getInt(it.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                phones = context.contentResolver.getData(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    selection = ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                    selectionArgs = arrayOf(id)
                ) {
                    it.getString(it.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER))
                }
            }
            Contact(
                it.getString(it.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME)),
                phones?.get(0) ?: ""
            )
        }
    }

    /**
     * Gets the last known location of the user.
     */
    @SuppressWarnings("MissingPermission")
    private fun getLocation(): Location {
        return with(context.getSystemService(Context.LOCATION_SERVICE) as LocationManager) {
            getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
        }
    }

}