package com.evgvin.loan.ui.log_in_steps.confirmation

import com.evgvin.loan.ui.registration_steps.phone_confirmation.PhoneConfirmationFragment

class ConfirmationFragment : PhoneConfirmationFragment() {

    override fun nextStep() {
        parentViewModel.showNextStepEvent.value = ConfirmationFragmentDirections.showPin()
    }

}