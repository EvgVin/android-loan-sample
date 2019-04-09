package com.evgvin.loan.ui.application_intro

import com.evgvin.loan.ui.base.BaseViewModel
import com.evgvin.loan.ui.common.SingleLiveEvent
import javax.inject.Inject

class ApplicationIntroViewModel @Inject constructor() : BaseViewModel() {

    val startApplicationEvent = SingleLiveEvent<Void>()

    fun onStartApplicationClick() {
        startApplicationEvent.call()
    }

}