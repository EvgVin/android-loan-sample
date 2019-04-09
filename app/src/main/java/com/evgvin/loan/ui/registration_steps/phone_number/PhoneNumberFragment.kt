package com.evgvin.loan.ui.registration_steps.phone_number

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentPhoneNumberBinding
import com.evgvin.loan.ui.steps_container.step.StepFragment

open class PhoneNumberFragment : StepFragment<FragmentPhoneNumberBinding, PhoneNumberViewModel>() {

    override lateinit var viewModel: PhoneNumberViewModel

    override fun getLayoutId() = R.layout.fragment_phone_number

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PhoneNumberViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun nextStep() {
        parentViewModel.showNextStepEvent.value = PhoneNumberFragmentDirections.showPhoneConfirmation()
    }

}