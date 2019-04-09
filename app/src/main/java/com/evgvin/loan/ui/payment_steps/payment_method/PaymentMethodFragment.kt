package com.evgvin.loan.ui.payment_steps.payment_method

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentPaymentMethodBinding
import com.evgvin.loan.ui.steps_container.step.StepFragment

class PaymentMethodFragment : StepFragment<FragmentPaymentMethodBinding, PaymentMethodViewModel>(),
    PaymentMethodNavigator {

    override val isLastStep = true

    override lateinit var viewModel: PaymentMethodViewModel

    override fun getLayoutId() = R.layout.fragment_payment_method

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PaymentMethodViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        viewModel.apply {
            paytmEvent.observe(this@PaymentMethodFragment, Observer<Void> {
                usePaytmMethod()
            })
        }
    }

    override fun usePaytmMethod() {

    }

    override fun nextStep() {}
}