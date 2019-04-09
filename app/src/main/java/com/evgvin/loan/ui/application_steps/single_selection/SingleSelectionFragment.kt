package com.evgvin.loan.ui.application_steps.single_selection

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.data.model.Question
import com.evgvin.loan.ui.application_steps.single_selection.SingleSelectionFragmentArgs.fromBundle
import com.evgvin.loan.ui.item_selection_list.SelectionListFragment

class SingleSelectionFragment : SelectionListFragment<SingleSelectionViewModel>() {

    override val selectionMode = SELECTION_MODE.SINGLE

    override lateinit var viewModel: SingleSelectionViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SingleSelectionViewModel::class.java)
        arguments?.let {
            val args = fromBundle(it)
            viewModel.currentQuestionId.value = args.questionId
        }
        super.onViewCreated(view, savedInstanceState)
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        viewModel.apply {
            question.observe(this@SingleSelectionFragment, Observer<Question?> {
                it?.let {
                    title.set(it.title)
                    description.set(it.description)
                    restoreSelectedValue(it.id)
                    stringItems.value = it.values.toTypedArray()
                }
            })
            selectedItemPositions.observe(this@SingleSelectionFragment, Observer<List<Int>?> {
                singleSelectedItemPosition?.let { viewModel.selectedValuePosition(it) }
            })
        }
    }

}