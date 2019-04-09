package com.evgvin.loan.ui.payment_steps.payment_method

import android.content.Context
import com.evgvin.loan.ui.common.SingleLiveEvent
import com.evgvin.loan.ui.steps_container.step.StepViewModel
import javax.inject.Inject

class PaymentMethodViewModel @Inject constructor(private val context: Context) : StepViewModel() {

    val paytmEvent = SingleLiveEvent<Void>()

    fun onPaytmClick() = paytmEvent.call()

}