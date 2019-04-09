package com.evgvin.loan.ui.main

import com.evgvin.loan.ui.base.BaseViewModel
import com.evgvin.loan.ui.common.SingleLiveEvent
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel() {

    val languageChosenEvent = SingleLiveEvent<Void>()

}