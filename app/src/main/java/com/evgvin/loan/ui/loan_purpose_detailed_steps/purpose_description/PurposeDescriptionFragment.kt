package com.evgvin.loan.ui.loan_purpose_detailed_steps.purpose_description

import android.os.Bundle
import android.view.View
import android.widget.PopupWindow
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.BR
import com.evgvin.loan.R
import com.evgvin.loan.data.model.Purpose
import com.evgvin.loan.databinding.FragmentPurposeDescriptionBinding
import com.evgvin.loan.ui.common.autoCleared
import com.evgvin.loan.ui.loan_purpose_detailed_steps.LoanPurposeDetailedStepsFragmentArgs
import com.evgvin.loan.ui.steps_container.step.StepFragment
import com.evgvin.loan.util.showPopupWindow

class PurposeDescriptionFragment: StepFragment<FragmentPurposeDescriptionBinding, PurposeDescriptionViewModel>(),
    PurposeDescriptionItemNavigator {

    override lateinit var viewModel: PurposeDescriptionViewModel

    private var purposePopupWindow: PopupWindow by autoCleared()

    override fun getLayoutId() = com.evgvin.loan.R.layout.fragment_purpose_description

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PurposeDescriptionViewModel::class.java)
        parentFragment.arguments?.let {
            val args = LoanPurposeDetailedStepsFragmentArgs.fromBundle(it)
            viewModel.currentPurposeId.value = args.purposeId
        }
        super.onViewCreated(view, savedInstanceState)
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        viewModel.apply {
            selectPurposeEvent.observe(this@PurposeDescriptionFragment, Observer<Void> {
                this.purposes.value?.let {
                    purposePopupWindow = viewDataBinding.etPurpose.showPopupWindow(
                            it,
                            this@PurposeDescriptionFragment,
                            R.layout.item_purpose_spinner,
                            BR.model
                        )
                }
            })
            purpose.observe(this@PurposeDescriptionFragment, Observer<Purpose?> {
                purpose.value?.let { this.currentPurposeName.set(it.name) }
            })
        }
    }

    override fun itemClicked(data: Purpose, position: Int) {
        viewModel.purposeSelected(data.id)
        purposePopupWindow.dismiss()
    }

    override fun nextStep() {
        parentViewModel.showNextStepEvent.value = PurposeDescriptionFragmentDirections.showOutstandingLoans()
    }

}