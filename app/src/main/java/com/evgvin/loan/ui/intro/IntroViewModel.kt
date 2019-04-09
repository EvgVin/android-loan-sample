package com.evgvin.loan.ui.intro

import com.evgvin.loan.ui.base.BaseViewModel
import com.evgvin.loan.ui.common.SingleLiveEvent
import javax.inject.Inject

class IntroViewModel @Inject constructor() : BaseViewModel() {

    val openRegistrationEvent = SingleLiveEvent<Void>()
    val openLogInEvent = SingleLiveEvent<Void>()

    fun onRegistrationClick() = openRegistrationEvent.call()

    fun onLogInClick() = openLogInEvent.call()

}