package com.evgvin.loan.ui.log_in_steps.pin

import android.os.Bundle
import android.view.View
import com.evgvin.loan.R
import com.evgvin.loan.ui.log_in_steps.LogInStepsFragmentDirections
import com.evgvin.loan.ui.registration_steps.pin_creation.PinCreationFragment

class PinFragment : PinCreationFragment() {

    override val isLastStep = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.apply {
            tvTitle.setText(R.string.pin_title)
            tvHelper.visibility = View.GONE
        }
    }

    override fun nextStep() {
        parentViewModel.navigateEvent.value = LogInStepsFragmentDirections.showHome()
    }

}