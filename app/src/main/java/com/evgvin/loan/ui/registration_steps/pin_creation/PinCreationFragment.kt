package com.evgvin.loan.ui.registration_steps.pin_creation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentPinCreationBinding
import com.evgvin.loan.ui.steps_container.step.StepFragment

open class PinCreationFragment : StepFragment<FragmentPinCreationBinding, PinCreationViewModel>() {

    override lateinit var viewModel: PinCreationViewModel

    override fun getLayoutId() = R.layout.fragment_pin_creation

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PinCreationViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun nextStep() {
        parentViewModel.showNextStepEvent.value = PinCreationFragmentDirections
            .showPinConfirmation(viewModel.pin.get())
    }

}