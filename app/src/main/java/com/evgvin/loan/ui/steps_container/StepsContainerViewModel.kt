package com.evgvin.loan.ui.steps_container

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.navigation.NavDirections
import com.evgvin.loan.ui.base.BaseViewModel
import com.evgvin.loan.ui.common.SingleLiveEvent

open class StepsContainerViewModel : BaseViewModel() {

    val nextStepName = ObservableField<String>()
    val enabledNextStep = ObservableBoolean(false)

    /**
     * Called when last step selected.
     */
    val lastStepEvent = SingleLiveEvent<Boolean>()

    val nextStepClickEvent = SingleLiveEvent<Void>()
    val showNextStepEvent = SingleLiveEvent<NavDirections>()

    /**
     * Used for navigation between other application fragments.
     */
    val navigateEvent = SingleLiveEvent<NavDirections>()

    fun onNextClick() = nextStepClickEvent.call()

}