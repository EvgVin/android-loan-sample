package com.evgvin.loan.ui.loan_congratulations

import androidx.databinding.ObservableField
import com.evgvin.loan.ui.base.BaseViewModel
import com.evgvin.loan.ui.common.SingleLiveEvent
import javax.inject.Inject

class LoanCongratulationsViewModel @Inject constructor() : BaseViewModel() {

    val monthlyRate = ObservableField<String>()
    val payback = ObservableField<String>()

    val selectAmountEvent = SingleLiveEvent<Void>()
    val notNowEvent = SingleLiveEvent<Void>()

    init {
        // Used only for tests.
        // ToDo: delete it after connecting to the server.
        monthlyRate.set("15%")
        payback.set("2 months")
    }

    fun onSelectAmountClick() = selectAmountEvent.call()

    fun onNotNowClick() = notNowEvent.call()

}