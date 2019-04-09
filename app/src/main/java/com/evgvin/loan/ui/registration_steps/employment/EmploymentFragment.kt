package com.evgvin.loan.ui.registration_steps.employment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.R
import com.evgvin.loan.ui.item_selection_list.SelectionListFragment
import com.evgvin.loan.ui.registration_steps.RegistrationStepsFragmentDirections

class EmploymentFragment : SelectionListFragment<EmploymentViewModel>() {

    override val selectionMode = SELECTION_MODE.MULTI

    override lateinit var viewModel: EmploymentViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(EmploymentViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        viewModel.title.set(getString(R.string.employment_title))
    }

    override fun nextStep() {
        parentViewModel.navigateEvent.value = RegistrationStepsFragmentDirections.showAllowPermissions()
    }

}