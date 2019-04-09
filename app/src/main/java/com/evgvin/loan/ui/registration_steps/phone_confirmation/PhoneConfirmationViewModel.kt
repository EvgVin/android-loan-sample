package com.evgvin.loan.ui.registration_steps.phone_confirmation

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import com.evgvin.loan.ui.steps_container.step.StepViewModel
import javax.inject.Inject

class PhoneConfirmationViewModel @Inject constructor() : StepViewModel() {

    val CONFIRMATION_CODE_LENGTH = 4

    val confirmationCode: ObservableField<String> by lazy {
        ObservableField<String>("").apply {
            addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    val code = this@apply.get() ?: ""
                    val isValidCode = code.length == CONFIRMATION_CODE_LENGTH
                    enabledNextStepEvent.value = isValidCode
                }
            })
        }
    }

    fun onSendAgainClick() {

    }

}