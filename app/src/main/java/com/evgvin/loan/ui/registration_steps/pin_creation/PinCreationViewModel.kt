package com.evgvin.loan.ui.registration_steps.pin_creation

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import com.evgvin.loan.ui.steps_container.step.StepViewModel
import javax.inject.Inject

open class PinCreationViewModel @Inject constructor() : StepViewModel() {

    val PIN_LENGTH = 4

    val pin: ObservableField<String> by lazy {
        ObservableField<String>("").apply {
            addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    val pin = this@apply.get() ?: ""
                    enabledNextStepEvent.value = isValidPin(pin)
                }
            })
        }
    }

    open fun isValidPin(text: String?) = !text.isNullOrEmpty() && text.length == PIN_LENGTH

}