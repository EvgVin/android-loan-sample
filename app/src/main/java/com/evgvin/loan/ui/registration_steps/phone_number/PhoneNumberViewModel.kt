package com.evgvin.loan.ui.registration_steps.phone_number

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import com.evgvin.loan.ui.steps_container.step.StepViewModel
import com.evgvin.loan.util.Utils
import javax.inject.Inject


class PhoneNumberViewModel @Inject constructor() : StepViewModel() {

    val phoneNumber: ObservableField<String> by lazy {
        ObservableField<String>("").apply {
            addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    val phone = this@apply.get() ?: ""
                    val isValidPhone = Utils.isPhoneValid(phone)
                    enabledNextStepEvent.value = isValidPhone
                }
            })
        }
    }

}