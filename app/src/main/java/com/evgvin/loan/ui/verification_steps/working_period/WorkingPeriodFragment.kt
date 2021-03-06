package com.evgvin.loan.ui.verification_steps.working_period

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.R
import com.evgvin.loan.ui.item_selection_list.SelectionListFragment
import com.evgvin.loan.ui.verification_steps.VerificationStepsFragmentDirections

class WorkingPeriodFragment : SelectionListFragment<WorkingPeriodViewModel>() {

    override val selectionMode = SELECTION_MODE.SINGLE

    override lateinit var viewModel: WorkingPeriodViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(WorkingPeriodViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        viewModel.title.set(getString(R.string.working_period_title))
    }

    override fun nextStep() {
        parentViewModel.navigateEvent.value = VerificationStepsFragmentDirections.showSelfie()
    }

}