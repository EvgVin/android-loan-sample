package com.evgvin.loan.ui.verification_steps

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.R
import com.evgvin.loan.ui.steps_container.static_container.StaticStepsContainerFragment

class VerificationStepsFragment : StaticStepsContainerFragment<VerificationStepsViewModel>() {

    override fun getGraphId() = R.navigation.verification_steps

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(VerificationStepsViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
    }

}