package com.evgvin.loan.ui.log_in_steps.phone

import android.os.Bundle
import android.view.View
import com.evgvin.loan.R
import com.evgvin.loan.ui.registration_steps.phone_number.PhoneNumberFragment

class PhoneFragment : PhoneNumberFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.tvDescription.apply {
            setText(R.string.phone_description)
            visibility = View.VISIBLE
        }
    }

    override fun nextStep() {
        parentViewModel.showNextStepEvent.value = PhoneFragmentDirections.showConfirmation()
    }

}