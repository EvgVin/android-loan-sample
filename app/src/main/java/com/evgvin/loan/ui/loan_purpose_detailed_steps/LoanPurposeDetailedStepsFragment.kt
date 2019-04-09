package com.evgvin.loan.ui.loan_purpose_detailed_steps

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.R
import com.evgvin.loan.ui.steps_container.static_container.StaticStepsContainerFragment

class LoanPurposeDetailedStepsFragment : StaticStepsContainerFragment<LoanPurposeDetailedStepsViewModel>() {

    override fun getGraphId() = R.navigation.loan_purpose_detailed_steps

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(LoanPurposeDetailedStepsViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
    }

}