package com.evgvin.loan.ui.home.feed

import com.evgvin.loan.ui.base.BaseViewModel
import com.evgvin.loan.ui.common.SingleLiveEvent
import javax.inject.Inject

class FeedViewModel @Inject constructor() : BaseViewModel() {

    val applyEvent = SingleLiveEvent<Void>()
    val referEvent = SingleLiveEvent<Void>()
    val increaseScoreEvent = SingleLiveEvent<Void>()

    fun onApplyClick() = applyEvent.call()

    fun onReferClick() = referEvent.call()

    fun onIncreaseClick() = increaseScoreEvent.call()

}