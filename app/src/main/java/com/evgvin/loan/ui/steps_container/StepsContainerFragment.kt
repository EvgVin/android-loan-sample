package com.evgvin.loan.ui.steps_container

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.appcompat.widget.Toolbar
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.evgvin.loan.R
import com.evgvin.loan.ui.base.BaseFragment
import com.evgvin.loan.util.setupActionBar

abstract class StepsContainerFragment<T : StepsContainerViewModel, V : ViewDataBinding>
    : BaseFragment<V, T>(), StepsContainerNavigator {

    override lateinit var viewModel: T

    open val nextStepLabel: String by lazy {
        getString(R.string.next_step)
    }

    open val lastStepLabel = ""

    abstract val toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupActionBar(toolbar, false) {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(false)
        }
        subscribeToStepsContainerLiveData()
    }

    private fun subscribeToStepsContainerLiveData() {
        viewModel.apply {
            // Called when last step selected to change "Next" button text (if needed)
            lastStepEvent.observe(this@StepsContainerFragment, Observer<Boolean> {
                this.nextStepName.set(if (it) lastStepLabel else nextStepLabel)
            })
            navigateEvent.observe(this@StepsContainerFragment, Observer<NavDirections> {
                navigate(it)
            })
        }
    }

    /**
     * Used for navigation between other fragments (steps) in [StepsContainerFragment].
     */
    @CallSuper
    open fun nextStep() {
        viewModel.enabledNextStep.set(false)
    }

    /**
     * Used for navigation between other application fragments.
     */
    override fun navigate(direction: NavDirections) {
        findNavController().navigate(direction)
    }

}