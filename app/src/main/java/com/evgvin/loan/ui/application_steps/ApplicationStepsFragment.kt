package com.evgvin.loan.ui.application_steps

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.evgvin.loan.data.model.Question
import com.evgvin.loan.ui.steps_container.dynamic_container.DynamicStepsContainerFragment
import com.evgvin.loan.util.showSnackbar

class ApplicationStepsFragment : DynamicStepsContainerFragment<ApplicationStepsViewModel>() {

    override val completeNavDirection = ApplicationStepsFragmentDirections.showLoanPurpose()

    override val pagerAdapter: ApplicationAdapter by lazy {
        ApplicationAdapter(childFragmentManager)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ApplicationStepsViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        subscribeToLivaData()
    }

    private fun subscribeToLivaData() {
        viewModel.apply {
            questions.observe(this@ApplicationStepsFragment, Observer<List<Question>> {
                it?.let { pagerAdapter.refreshQuestions(it) }
            })
            snackbarMessage.observe(this@ApplicationStepsFragment, Observer<String> {
                viewDataBinding.root.showSnackbar(it, Snackbar.LENGTH_SHORT)
            })
        }
    }

}