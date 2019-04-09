package com.evgvin.loan.ui.verification_steps.gender

import android.os.Bundle
import android.view.View
import android.widget.PopupWindow
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentGenderBinding
import com.evgvin.loan.ui.common.autoCleared
import com.evgvin.loan.ui.steps_container.step.StepFragment
import com.evgvin.loan.util.showPopupWindow


class GenderFragment : StepFragment<FragmentGenderBinding, GenderViewModel>(), GenderItemNavigator {

    override lateinit var viewModel: GenderViewModel

    private var genderPopupWindow: PopupWindow by autoCleared()

    override fun getLayoutId() = com.evgvin.loan.R.layout.fragment_gender

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(GenderViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        viewModel.apply {
            selectGenderEvent.observe(this@GenderFragment, Observer<Void> {
                genderPopupWindow = viewDataBinding.etGender.showPopupWindow(
                    resources.getStringArray(R.array.gender_items).toList(),
                    this@GenderFragment
                )
            })
        }
    }

    override fun itemClicked(data: String, position: Int) {
        viewModel.genderSelected(data)
        genderPopupWindow.dismiss()
    }

    override fun nextStep() {
        parentViewModel.showNextStepEvent.value = GenderFragmentDirections.showHomeAddress()
    }

}