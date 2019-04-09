package com.evgvin.loan.ui.registration_steps.pin_confirmation

import com.evgvin.loan.ui.registration_steps.pin_creation.PinCreationViewModel
import javax.inject.Inject

class PinConfirmationViewModel @Inject constructor() : PinCreationViewModel() {

    var createdPin: String? = null

    override fun isValidPin(text: String?) = super.isValidPin(text) && text == createdPin

}