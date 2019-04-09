package com.evgvin.loan.ui.registration_steps.education_level

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.R
import com.evgvin.loan.ui.item_selection_list.SelectionListFragment

class EducationLevelFragment : SelectionListFragment<EducationLevelViewModel>() {

    override val selectionMode = SELECTION_MODE.SINGLE

    override lateinit var viewModel: EducationLevelViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(EducationLevelViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        viewModel.title.set(getString(R.string.education_level_title))
    }

    override fun nextStep() {
        parentViewModel.showNextStepEvent.value = EducationLevelFragmentDirections.showEmployment()
    }

}