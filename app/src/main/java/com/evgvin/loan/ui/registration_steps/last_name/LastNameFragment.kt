package com.evgvin.loan.ui.registration_steps.last_name

import android.os.Bundle
import android.view.View
import com.evgvin.loan.R
import com.evgvin.loan.ui.registration_steps.first_name.FirstNameFragment

class LastNameFragment : FirstNameFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.apply {
            tvTitle.text = getString(R.string.last_name_title)
            textInputLayout.hint = getString(R.string.last_name_hint)
        }
    }

    override fun nextStep() {
        parentViewModel.showNextStepEvent.value = LastNameFragmentDirections.showEducationLevel()
    }

}