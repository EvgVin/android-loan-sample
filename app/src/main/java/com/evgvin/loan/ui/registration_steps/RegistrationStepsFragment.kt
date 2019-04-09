package com.evgvin.loan.ui.registration_steps

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.R
import com.evgvin.loan.ui.main.MainViewModel
import com.evgvin.loan.ui.steps_container.static_container.StaticStepsContainerFragment

class RegistrationStepsFragment : StaticStepsContainerFragment<RegistrationStepsViewModel>() {

    override fun getGraphId() = R.navigation.registration_steps

    lateinit var parentViewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(RegistrationStepsViewModel::class.java)
        parentViewModel = ViewModelProviders.of(baseActivity, viewModelFactory).get(MainViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        parentViewModel.languageChosenEvent.observe(this, Observer<Void> {
            // The application language changes only after calling [Activity.recreate]
            baseActivity.recreate()
        })
    }

}