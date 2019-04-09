package com.evgvin.loan.ui.verification_steps.date_of_birth

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import com.evgvin.loan.ui.steps_container.step.StepViewModel
import com.evgvin.loan.util.Utils
import javax.inject.Inject

class DateOfBirthViewModel @Inject constructor() : StepViewModel() {

    val DATE_PATTERN = "dd/MM/yyyy"

    val dateOfBirth: ObservableField<String> by lazy {
        ObservableField<String>("").apply {
            addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    val date = this@apply.get() ?: ""
                    val isValidDate = Utils.isDateValid(date, DATE_PATTERN)
                    enabledNextStepEvent.value = isValidDate
                }
            })
        }
    }

}