package com.evgvin.loan.ui.log_in_steps

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.R
import com.evgvin.loan.ui.steps_container.static_container.StaticStepsContainerFragment

class LogInStepsFragment : StaticStepsContainerFragment<LogInStepsViewModel>() {

    override val lastStepLabel by lazy {
        getString(R.string.sign_in_action)
    }

    override fun getGraphId() = R.navigation.log_in_steps

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LogInStepsViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
    }

}