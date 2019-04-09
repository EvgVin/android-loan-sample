package com.evgvin.loan.ui.payment_steps.payment_amount

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentPaymentAmountBinding
import com.evgvin.loan.ui.steps_container.step.StepFragment

class PaymentAmountFragment : StepFragment<FragmentPaymentAmountBinding, PaymentAmountViewModel>() {

    override lateinit var viewModel: PaymentAmountViewModel

    override fun getLayoutId() = R.layout.fragment_payment_amount

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PaymentAmountViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun nextStep() {
        parentViewModel.showNextStepEvent.value = PaymentAmountFragmentDirections.showPaymentMethod()
    }
}