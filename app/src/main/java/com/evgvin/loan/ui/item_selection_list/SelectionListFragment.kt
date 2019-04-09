package com.evgvin.loan.ui.item_selection_list

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.evgvin.loan.R
import com.evgvin.loan.data.model.SelectionItem
import com.evgvin.loan.databinding.FragmentSelectionListBinding
import com.evgvin.loan.ui.common.SingleLiveEvent
import com.evgvin.loan.ui.common.autoCleared
import com.evgvin.loan.ui.item_selection_list.SelectionListFragment.SELECTION_MODE
import com.evgvin.loan.ui.steps_container.step.StepFragment
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * This class is used to show list of [SelectionItem].
 * User must select one or more items (depends on [SELECTION_MODE]).
 */
abstract class SelectionListFragment<V : SelectionListViewModel>
    : StepFragment<FragmentSelectionListBinding, V>(), SelectionItemNavigator {

    /**
     * All selection modes of the list.
     */
    enum class SELECTION_MODE {
        SINGLE,
        MULTI
    }

    abstract val selectionMode: SELECTION_MODE

    var rvAdapter: SelectionListAdapter by autoCleared()

    override fun getLayoutId() = R.layout.fragment_selection_list

    /**
     * Helps to safely call [setupEnabledNextStep] when [ViewModel] is already initialized.
      */
    private val stepSelectedEvent = SingleLiveEvent<Void>()

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSelectionList()
        subscribeToLiveData()
    }

    private fun setupSelectionList() {
        rvAdapter = SelectionListAdapter(this, selectionMode)
        viewDataBinding.rvItems.apply {
            layoutManager = LinearLayoutManager(this@SelectionListFragment.context)
            adapter = rvAdapter
        }
    }

    private fun subscribeToLiveData() {
        viewModel.apply {
            selectionItems.observe(this@SelectionListFragment, Observer<List<SelectionItem>> {
                it?.let { rvAdapter.refreshList(it) }
            })
            selectedItemPositions.observe(this@SelectionListFragment, Observer<List<Int>?> {
                setupEnabledNextStep()
            })
        }
        stepSelectedEvent.observe(this, Observer {
            setupEnabledNextStep()
        })
    }

    private fun setupEnabledNextStep() {
        viewModel.apply { enabledNextStepEvent.value = enabledNextStep()}
    }

    override fun stepSelected() {
        stepSelectedEvent.call()
    }

    override fun itemSelected(item: SelectionItem?, position: Int) {
        viewModel.apply {
            if (selectionMode == SELECTION_MODE.MULTI) {
                itemSelectedMultiMode(position, item)
            } else {
                singleSelectedItemPosition?.let {
                    this.selectionItems.value?.get(it)?.isSelected = false
                    AndroidSchedulers.mainThread().scheduleDirect { rvAdapter.notifyItemChanged(it) }
                }
                itemSelectedSingleMode(position)
            }
        }
    }

}