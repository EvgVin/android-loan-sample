package com.evgvin.loan.ui.verification_steps.gender

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import com.evgvin.loan.ui.common.SingleLiveEvent
import com.evgvin.loan.ui.steps_container.step.StepViewModel
import javax.inject.Inject

class GenderViewModel @Inject constructor() : StepViewModel() {

    val currentGenderName: ObservableField<String> by lazy {
        ObservableField<String>("").apply {
            addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    enabledNextStepEvent.value = true
                }
            })
        }
    }

    val selectGenderEvent = SingleLiveEvent<Void>()

    fun onSelectGenderClick() = selectGenderEvent.call()

    fun genderSelected(name: String) = currentGenderName.set(name)

}