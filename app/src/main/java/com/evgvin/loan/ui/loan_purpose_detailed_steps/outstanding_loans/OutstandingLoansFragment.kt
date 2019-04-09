package com.evgvin.loan.ui.loan_purpose_detailed_steps.outstanding_loans

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.R
import com.evgvin.loan.ui.item_selection_list.SelectionListFragment
import com.evgvin.loan.ui.loan_purpose_detailed_steps.LoanPurposeDetailedStepsFragmentDirections

class OutstandingLoansFragment : SelectionListFragment<OutstandingLoansViewModel>() {

    override val selectionMode = SELECTION_MODE.SINGLE

    override lateinit var viewModel: OutstandingLoansViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(OutstandingLoansViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        viewModel.title.set(getString(R.string.outstanding_loans_title))
    }

    override fun nextStep() {
        parentViewModel.navigateEvent.value = LoanPurposeDetailedStepsFragmentDirections.showLoanCongratulations()
    }

}