package com.evgvin.loan.ui.steps_container.step

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.evgvin.loan.ui.base.BaseFragment
import com.evgvin.loan.ui.steps_container.StepsContainerFragment
import com.evgvin.loan.ui.steps_container.StepsContainerViewModel
import javax.inject.Inject

abstract class StepFragment<T : ViewDataBinding, V : StepViewModel> : BaseFragment<T, V>(), StepNavigator {

    open val isLastStep = false

    @Inject
    lateinit var parentFragment: StepsContainerFragment<out StepsContainerViewModel, out ViewDataBinding>

    val parentViewModel: StepsContainerViewModel
        get() = parentFragment.viewModel

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentViewModel.lastStepEvent.value = isLastStep
        subscribeToStepLiveData()
    }

    private fun subscribeToStepLiveData() {
        parentViewModel.apply {
            nextStepClickEvent.observe(this@StepFragment, Observer<Void> {
                nextStep()
            })
        }
        viewModel.apply {
            enabledNextStepEvent.observe(this@StepFragment, Observer<Boolean> {
                parentViewModel.enabledNextStep.set(it)
            })
        }
    }

}