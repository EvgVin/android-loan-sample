package com.evgvin.loan.ui.registration_steps.last_name

import com.evgvin.loan.data.repository.UserRepository
import com.evgvin.loan.ui.registration_steps.first_name.FirstNameViewModel
import javax.inject.Inject

class LastNameViewModel @Inject constructor(
    userRepository: UserRepository
) : FirstNameViewModel(userRepository) {

    override fun getName() = userRepository.lastName

    override fun saveName(name: String) {
        userRepository.lastName = name
    }

}