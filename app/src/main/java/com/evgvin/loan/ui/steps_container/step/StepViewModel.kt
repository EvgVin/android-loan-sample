package com.evgvin.loan.ui.steps_container.step

import androidx.lifecycle.MutableLiveData
import com.evgvin.loan.ui.base.BaseViewModel

open class StepViewModel : BaseViewModel() {

    val enabledNextStepEvent = MutableLiveData<Boolean>()

}