package com.evgvin.loan.ui.steps_container.static_container

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.annotation.NavigationRes
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentStepsContainerBinding
import com.evgvin.loan.ui.steps_container.StepsContainerFragment
import com.evgvin.loan.ui.steps_container.StepsContainerViewModel
import com.evgvin.loan.util.canNavigateUp

abstract class StaticStepsContainerFragment<T : StepsContainerViewModel>
    : StepsContainerFragment<T, FragmentStepsContainerBinding>(), StaticStepsContainerNavigator {

    @NavigationRes
    abstract fun getGraphId(): Int

    override fun getLayoutId() = R.layout.fragment_steps_container

    override lateinit var viewModel: T

    private val stepsController: NavController by lazy {
        Navigation.findNavController(viewDataBinding.root.findViewById(R.id.stepsContainer))
    }

    override lateinit var toolbar: Toolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        stepsController.setGraph(getGraphId())
        toolbar = viewDataBinding.toolbar
        super.onViewCreated(view, savedInstanceState)
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        viewModel.apply {
            showNextStepEvent.observe(this@StaticStepsContainerFragment, Observer<NavDirections> {
                nextStep(it)
            })
        }
    }

    override fun nextStep(direction: NavDirections) {
        super.nextStep()
        stepsController.navigate(direction)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                if (stepsController.canNavigateUp()) {
                    stepsController.navigateUp()
                } else {
                    findNavController().navigateUp()
                }
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

}