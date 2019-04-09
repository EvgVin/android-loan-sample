package com.evgvin.loan.ui.steps_container.dynamic_container

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentStepsContainerDynamicBinding
import com.evgvin.loan.ui.steps_container.StepsContainerFragment
import com.evgvin.loan.ui.steps_container.StepsContainerViewModel
import com.evgvin.loan.ui.steps_container.step.StepNavigator

abstract class DynamicStepsContainerFragment<T : StepsContainerViewModel>
    : StepsContainerFragment<T, FragmentStepsContainerDynamicBinding>(), DynamicStepsContainerNavigator {

    val PAGER_STATE = "ViewPagerState"

    override fun getLayoutId() = R.layout.fragment_steps_container_dynamic

    abstract val pagerAdapter: FragmentStatePagerAdapter

    /**
     * Used in the last step to complete the stepper and open a new fragment.
     */
    abstract val completeNavDirection: NavDirections

    var currentItemPosition = -1
        set(value) {
            val progress = (value + 1) / pagerAdapter.count.toFloat() * 100
            viewDataBinding.progressBar.progress = progress.toInt()
            field = value
        }

    override lateinit var toolbar: Toolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        toolbar = viewDataBinding.toolbar
        setupViewPager(savedInstanceState)
        super.onViewCreated(view, savedInstanceState)
        subscribeToLiveData()
    }

    override fun onSaveInstanceState(state: Bundle) {
        state.putParcelable(PAGER_STATE, viewDataBinding.viewPager.onSaveInstanceState())
        super.onSaveInstanceState(state)
    }

    private fun setupViewPager(savedInstanceState: Bundle?) {
        viewDataBinding.viewPager.apply {
            swipeEnabled = false
            adapter = pagerAdapter
            addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrollStateChanged(state: Int) {
                    if (ViewPager.SCROLL_STATE_IDLE == state) {
                        getStepNavigator(currentItemPosition).stepSelected()
                    }
                }

                /**
                 * This method used for the start position initialization only
                 */
                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                    if (currentItemPosition == -1) onPageSelected(position)
                }

                override fun onPageSelected(position: Int) {
                    currentItemPosition = position
                }
            })
            onRestoreInstanceState(savedInstanceState?.getParcelable(PAGER_STATE))
        }
    }

    private fun getStepNavigator(position: Int) = pagerAdapter.getItem(position) as StepNavigator

    private fun subscribeToLiveData() {
        viewModel.apply {
            nextStepClickEvent.observe(this@DynamicStepsContainerFragment, Observer<Void> {
                nextStep()
            })
        }
    }

    /**
     * Navigates to the next step or opens a new fragment through [completeNavDirection].
     */
    override fun nextStep() {
        super.nextStep()
        if (currentItemPosition < pagerAdapter.count - 1) {
            viewDataBinding.viewPager.setCurrentItem(++currentItemPosition, true)
        } else if (currentItemPosition == pagerAdapter.count - 1) {
            navigate(completeNavDirection)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Navigates to the previous step until [currentItemPosition] > 0 otherwise navigates up.
                if (currentItemPosition > 0) {
                    viewDataBinding.viewPager.setCurrentItem(--currentItemPosition, true)
                } else if (currentItemPosition == 0) {
                    findNavController().navigateUp()
                }
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

}