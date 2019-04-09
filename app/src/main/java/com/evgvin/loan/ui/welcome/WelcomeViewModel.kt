package com.evgvin.loan.ui.welcome

import android.content.Context
import androidx.databinding.ObservableField
import com.evgvin.loan.R
import com.evgvin.loan.data.repository.UserRepository
import com.evgvin.loan.ui.base.BaseViewModel
import com.evgvin.loan.ui.common.SingleLiveEvent
import javax.inject.Inject

class WelcomeViewModel @Inject constructor(
    context: Context,
    userRepository: UserRepository
) : BaseViewModel() {

    val userName = ObservableField<String>()

    val verifyIdentityEvent = SingleLiveEvent<Void>()
    val skipEvent = SingleLiveEvent<Void>()

    init {
        userName.set(String.format(context.getString(R.string.welcome_title), userRepository.firstName))
    }

    fun onVerifyIdentityClick() = verifyIdentityEvent.call()

    fun onSkipClick() = skipEvent.call()

}