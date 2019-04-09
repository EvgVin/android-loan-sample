package com.evgvin.loan.data.repository

import androidx.lifecycle.MutableLiveData
import com.evgvin.loan.data.local.PreferenceManager
import com.evgvin.loan.data.model.Address
import com.evgvin.loan.ui.common.SingleLiveEvent
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val preferenceManager: PreferenceManager) {

    val avatarFile = SingleLiveEvent<File>()

    var firstName = ""
    var lastName = ""

    val homeAddress = Address()
    val workAddress = Address()

    val languageCode = MutableLiveData<String>()

    init {
        languageCode.value = preferenceManager.currentLocaleCode
    }

    /**
     * Changes default locale [code] of the app.
     */
    fun changeLanguageCode(code: String) {
        preferenceManager.currentLocaleCode = code
        languageCode.value = code
    }

}