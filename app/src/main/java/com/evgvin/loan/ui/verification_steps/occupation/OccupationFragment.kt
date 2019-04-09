package com.evgvin.loan.ui.verification_steps.occupation

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.R
import com.evgvin.loan.data.model.Occupation
import com.evgvin.loan.databinding.FragmentOccupationBinding
import com.evgvin.loan.ui.common.autoCleared
import com.evgvin.loan.ui.steps_container.step.StepFragment
import com.evgvin.loan.util.setupArrayAdapter

class OccupationFragment : StepFragment<FragmentOccupationBinding, OccupationViewModel>() {

    override lateinit var viewModel: OccupationViewModel

    private var tvAdapter: ArrayAdapter<Occupation> by autoCleared()

    override fun getLayoutId() = R.layout.fragment_occupation

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(OccupationViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        setupOccupationsTextView()
        subscribeToLiveData()
    }

    private fun setupOccupationsTextView() {
        tvAdapter = setupArrayAdapter()
        viewDataBinding.tvOccupation.apply {
            setAdapter(tvAdapter)
            dropDownAnchor = R.id.textInputLayout
        }
    }

    private fun subscribeToLiveData() {
        viewModel.occupationsList.observe(this, Observer<List<Occupation>> {
            it?.let {
                tvAdapter.addAll(it)
                tvAdapter.notifyDataSetChanged()
            }
        })
    }

    override fun nextStep() {
        parentViewModel.showNextStepEvent.value = OccupationFragmentDirections.showWorkAddress()
    }

}