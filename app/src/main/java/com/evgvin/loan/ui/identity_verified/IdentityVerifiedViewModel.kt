package com.evgvin.loan.ui.identity_verified

import com.evgvin.loan.ui.base.BaseViewModel
import com.evgvin.loan.ui.common.SingleLiveEvent
import javax.inject.Inject

class IdentityVerifiedViewModel @Inject constructor() : BaseViewModel() {

    val okEvent = SingleLiveEvent<Void>()

    fun onOkClick() = okEvent.call()

}