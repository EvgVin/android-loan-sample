package com.evgvin.loan.ui.registration_steps.choose_language

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentChooseLanguageBinding
import com.evgvin.loan.ui.registration_steps.RegistrationStepsFragmentDirections
import com.evgvin.loan.ui.steps_container.step.StepFragment

class ChooseLanguageFragment : StepFragment<FragmentChooseLanguageBinding, ChooseLanguageViewModel>(),
    ChooseLanguageNavigator {

    override lateinit var viewModel: ChooseLanguageViewModel

    override fun getLayoutId() = R.layout.fragment_choose_language

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ChooseLanguageViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        viewModel.apply {
            chooseLanguageEvent.observe(this@ChooseLanguageFragment, Observer<Void> {
                showLanguages()
            })
            languageCode.observe(this@ChooseLanguageFragment, Observer<String> {
                it?.let { updateLanguageName(it) }
            })
        }
    }

    override fun showLanguages() {
        parentViewModel.navigateEvent.value = RegistrationStepsFragmentDirections.showLanguages()
    }

    override fun nextStep() {
        parentViewModel.showNextStepEvent.value = ChooseLanguageFragmentDirections.showPhoneNumber()
    }

}