package com.evgvin.loan.ui.registration_steps.pin_confirmation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentPinCreationBinding
import com.evgvin.loan.ui.steps_container.step.StepFragment

class PinConfirmationFragment : StepFragment<FragmentPinCreationBinding, PinConfirmationViewModel>() {

    override lateinit var viewModel: PinConfirmationViewModel

    override fun getLayoutId() = R.layout.fragment_pin_creation

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PinConfirmationViewModel::class.java)
        arguments?.let {
            val args = PinConfirmationFragmentArgs.fromBundle(it)
            viewModel.createdPin = args.createdPin
        }
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.apply {
            tvTitle.text = getString(R.string.pin_confirmation_title)
            tvHelper.text = getString(R.string.pin_confirmation_helper)
        }
    }

    override fun nextStep() {
        parentViewModel.showNextStepEvent.value = PinConfirmationFragmentDirections.showEmailEntering()
    }
}