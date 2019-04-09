package com.evgvin.loan.ui.verification_steps.home_address

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.annotation.CallSuper
import androidx.annotation.IdRes
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentHomeAddressBinding
import com.evgvin.loan.ui.common.autoCleared
import com.evgvin.loan.ui.steps_container.step.StepFragment
import com.evgvin.loan.util.setupArrayAdapter

open class HomeAddressFragment : StepFragment<FragmentHomeAddressBinding, HomeAddressViewModel>() {

    override lateinit var viewModel: HomeAddressViewModel

    override fun getLayoutId() = R.layout.fragment_home_address

    private var tvStateAdapter: ArrayAdapter<String> by autoCleared()

    private var tvCityAdapter: ArrayAdapter<String> by autoCleared()

    private var tvStreetAdapter: ArrayAdapter<String> by autoCleared()

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeAddressViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        setupTextViews()
        subscribeToLiveData()
    }

    private fun setupTextViews() {
        viewDataBinding.apply {
            setupAutocompleteTextView(tvState, R.id.textInputLayoutState) { tvStateAdapter = it }
            setupAutocompleteTextView(tvCity, R.id.textInputLayoutCity) { tvCityAdapter = it }
            setupAutocompleteTextView(tvStreet, R.id.textInputLayoutStreet) { tvStreetAdapter = it }
        }
    }

    private fun setupAutocompleteTextView(
        view: AutoCompleteTextView,
        @IdRes dropDownAnchorId: Int,
        action: (ArrayAdapter<String>) -> Unit
    ) {
        view.run {
            val arrayAdapter = setupArrayAdapter<String>()
            setAdapter(arrayAdapter)
            dropDownAnchor = dropDownAnchorId
            action(arrayAdapter)
        }
    }

    private fun subscribeToLiveData() {
        viewModel.apply {
            statePredictions.observe(this@HomeAddressFragment, Observer<List<String>> {
                it?.let { setupNewAutocompleteList(tvStateAdapter, it) }
            })
            cityPredictions.observe(this@HomeAddressFragment, Observer<List<String>> {
                it?.let { setupNewAutocompleteList(tvCityAdapter, it) }
            })
            streetPredictions.observe(this@HomeAddressFragment, Observer<List<String>> {
                it?.let { setupNewAutocompleteList(tvStreetAdapter, it) }
            })
        }
    }

    private fun setupNewAutocompleteList(arrayAdapter: ArrayAdapter<String>, newList: List<String>) {
        arrayAdapter.apply {
            clear()
            addAll(newList)
            notifyDataSetChanged()
        }
    }

    override fun nextStep() {
        parentViewModel.showNextStepEvent.value = HomeAddressFragmentDirections.showOccupation()
    }

}