package com.evgvin.loan.ui.item_selection_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.evgvin.loan.data.model.SelectionItem
import com.evgvin.loan.databinding.ItemMultiSelectionBinding
import com.evgvin.loan.databinding.ItemSingleSelectionBinding
import com.evgvin.loan.ui.base.BaseRecyclerAdapter
import com.evgvin.loan.ui.base.BaseViewHolder

class SelectionListAdapter(
    val itemNavigator: SelectionItemNavigator,
    val mode: SelectionListFragment.SELECTION_MODE
) : BaseRecyclerAdapter<SelectionItem, ViewDataBinding>() {

    override fun getItemViewType(position: Int): Int {
        return mode.ordinal
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<SelectionItem, ViewDataBinding> {
        return when(viewType) {
            SelectionListFragment.SELECTION_MODE.SINGLE.ordinal -> {
                val itemViewBinding = ItemSingleSelectionBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
                SingleSelectionItemViewHolder(itemViewBinding, itemNavigator)
            }
            else -> {
                val itemViewBinding = ItemMultiSelectionBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
                MultiSelectionItemViewHolder(itemViewBinding, itemNavigator)
            }
        }
    }

}