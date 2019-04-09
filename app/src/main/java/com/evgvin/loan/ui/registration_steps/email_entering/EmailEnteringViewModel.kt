package com.evgvin.loan.ui.registration_steps.email_entering

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import com.evgvin.loan.ui.common.SingleLiveEvent
import com.evgvin.loan.ui.steps_container.step.StepViewModel
import com.evgvin.loan.util.Utils
import javax.inject.Inject

class EmailEnteringViewModel @Inject constructor() : StepViewModel() {

    val email: ObservableField<String> by lazy {
        ObservableField<String>("").apply {
            addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    val email = this@apply.get() ?: ""
                    val isValidEmail = Utils.isEmailValid(email)
                    enabledNextStepEvent.value = isValidEmail
                }
            })
        }
    }

    val skipEvent = SingleLiveEvent<Void>()

    fun onSkipClick() = skipEvent.call()

}