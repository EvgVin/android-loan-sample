package com.evgvin.loan.ui.registration_steps.choose_language

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import com.evgvin.loan.data.repository.UserRepository
import com.evgvin.loan.ui.common.SingleLiveEvent
import com.evgvin.loan.ui.steps_container.step.StepViewModel
import java.util.*
import javax.inject.Inject

class ChooseLanguageViewModel @Inject constructor(
    userRepository: UserRepository
) : StepViewModel() {

    val languageCode: LiveData<String> = userRepository.languageCode
    val currentLanguageName = ObservableField<String>()

    val chooseLanguageEvent = SingleLiveEvent<Void>()

    init {
        currentLanguageName.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                enabledNextStepEvent.value = true
            }
        })
    }

    fun updateLanguageName(languageCode: String) = currentLanguageName.set(Locale(languageCode).displayName)

    fun onChooseLanguageClick() = chooseLanguageEvent.call()

}