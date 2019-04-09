package com.evgvin.loan.ui.registration_steps.first_name

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentFirstNameBinding
import com.evgvin.loan.ui.steps_container.step.StepFragment

open class FirstNameFragment : StepFragment<FragmentFirstNameBinding, FirstNameViewModel>() {

    override lateinit var viewModel: FirstNameViewModel

    override fun getLayoutId() = R.layout.fragment_first_name

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(FirstNameViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun nextStep() {
        parentViewModel.showNextStepEvent.value = FirstNameFragmentDirections.showLastName()
    }

}