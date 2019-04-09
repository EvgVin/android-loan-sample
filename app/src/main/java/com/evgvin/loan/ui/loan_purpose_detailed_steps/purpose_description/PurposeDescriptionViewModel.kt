package com.evgvin.loan.ui.loan_purpose_detailed_steps.purpose_description

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.evgvin.loan.data.model.Purpose
import com.evgvin.loan.data.repository.LoanPurposeRepository
import com.evgvin.loan.ui.common.SingleLiveEvent
import com.evgvin.loan.ui.steps_container.step.StepViewModel
import javax.inject.Inject

class PurposeDescriptionViewModel @Inject constructor(
    private val loanPurposeRepository: LoanPurposeRepository
) : StepViewModel() {

    val MAX_PURPOSE_DESCRIPTION_LENGTH = 2500

    val currentPurposeId = MutableLiveData<Int>()
    val purpose: LiveData<Purpose?> = Transformations.map(currentPurposeId) { loanPurposeRepository.getItem(it) }

    val purposes: MutableLiveData<List<Purpose>> by lazy {
        MutableLiveData<List<Purpose>>().apply { this.value = loanPurposeRepository.itemsList }
    }

    val currentPurposeName: ObservableField<String> by lazy {
        ObservableField<String>("").apply {
            addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    validatePurpose()
                }
            })
        }
    }

    val currentPurposeDescription: ObservableField<String> by lazy {
        ObservableField<String>("").apply {
            addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    validatePurpose()
                }
            })
        }
    }

    val selectPurposeEvent = SingleLiveEvent<Void>()

    fun onSelectPurposeClick() = selectPurposeEvent.call()

    fun purposeSelected(purposeId: Int) {
        currentPurposeId.value = purposeId
    }

    fun validatePurpose() {
        var isValidPurpose = true
        if (currentPurposeId.value == null || currentPurposeDescription.get().isNullOrEmpty()) {
            isValidPurpose = false
        }
        enabledNextStepEvent.value = isValidPurpose
    }
}