package com.evgvin.loan.ui.verification_steps.date_of_birth

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentDateOfBirthBinding
import com.evgvin.loan.ui.steps_container.step.StepFragment

class DateOfBirthFragment : StepFragment<FragmentDateOfBirthBinding, DateOfBirthViewModel>() {

    override lateinit var viewModel: DateOfBirthViewModel

    override fun getLayoutId() = R.layout.fragment_date_of_birth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(DateOfBirthViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun nextStep() {
        parentViewModel.showNextStepEvent.value = DateOfBirthFragmentDirections.showGender()
    }

}