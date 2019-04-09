package com.evgvin.loan.ui.verification_steps.work_address

import android.content.Context
import com.evgvin.loan.data.repository.AddressPredictionsRepository
import com.evgvin.loan.data.repository.UserRepository
import com.evgvin.loan.ui.verification_steps.home_address.HomeAddressViewModel
import javax.inject.Inject

class WorkAddressViewModel @Inject constructor(
    context: Context,
    addressPredictionsRepository: AddressPredictionsRepository,
    userRepository: UserRepository
) : HomeAddressViewModel(context, addressPredictionsRepository, userRepository) {

    override val address = userRepository.workAddress

}