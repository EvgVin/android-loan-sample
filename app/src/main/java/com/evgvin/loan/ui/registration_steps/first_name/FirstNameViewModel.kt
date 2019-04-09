package com.evgvin.loan.ui.registration_steps.first_name

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import com.evgvin.loan.data.repository.UserRepository
import com.evgvin.loan.ui.steps_container.step.StepViewModel
import com.evgvin.loan.util.Utils
import javax.inject.Inject

open class FirstNameViewModel @Inject constructor(protected val userRepository: UserRepository) : StepViewModel() {

    val name: ObservableField<String> by lazy {
        ObservableField<String>().apply {
            addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    val name = this@apply.get() ?: ""
                    val isValidName = Utils.isNameValid(name)
                    if (isValidName) saveName(name)
                    enabledNextStepEvent.value = isValidName
                }
            })
            set(getName())
        }
    }

    open fun getName() = userRepository.firstName

    open fun saveName(name: String) {
        userRepository.firstName = name
    }

}