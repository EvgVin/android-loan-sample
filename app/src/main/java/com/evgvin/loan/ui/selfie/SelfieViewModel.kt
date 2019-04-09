package com.evgvin.loan.ui.selfie

import android.content.Context
import androidx.lifecycle.LiveData
import com.evgvin.loan.R
import com.evgvin.loan.data.repository.UserRepository
import com.evgvin.loan.ui.base.BaseViewModel
import com.evgvin.loan.ui.common.SingleLiveEvent
import io.reactivex.Single
import java.io.BufferedOutputStream
import java.io.File
import javax.inject.Inject

class SelfieViewModel @Inject constructor(
    private val context: Context,
    private val userRepository: UserRepository
) : BaseViewModel() {

    private val photoFile = File(context.cacheDir, "avatar.jpg")

    val savedAvatarFile: LiveData<File>
        get() = userRepository.avatarFile

    val makePhotoEvent = SingleLiveEvent<Void>()
    val snackbarMessage = SingleLiveEvent<String>()

    fun onMakePhotoClick() = makePhotoEvent.call()

    /**
     * Saves user photo.
     * Selfie photo is used on the server for identification.
     */
    fun savePhoto(data: ByteArray) {
        compositeDisposable.add(Single
            .create<File> {
                photoFile.apply {
                    createNewFile()
                    BufferedOutputStream(outputStream()).use { it.write(data) }
                    it.onSuccess(this)
                }
            }
            .subscribe({
                userRepository.avatarFile.value = it
            }, {
                snackbarMessage.value = context.getString(R.string.languages_error)
            }))
    }

}