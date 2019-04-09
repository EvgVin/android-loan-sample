package com.evgvin.loan.ui.payment_steps

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.R
import com.evgvin.loan.ui.steps_container.static_container.StaticStepsContainerFragment

class PaymentStepsFragment : StaticStepsContainerFragment<PaymentStepsViewModel>() {

    override val lastStepLabel = ""

    override fun getGraphId() = R.navigation.payment_steps

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PaymentStepsViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
    }
}