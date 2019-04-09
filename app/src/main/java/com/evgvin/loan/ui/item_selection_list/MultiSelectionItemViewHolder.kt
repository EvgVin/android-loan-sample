package com.evgvin.loan.ui.item_selection_list

import com.evgvin.loan.BR
import com.evgvin.loan.data.model.SelectionItem
import com.evgvin.loan.databinding.ItemMultiSelectionBinding
import com.evgvin.loan.ui.base.BaseViewHolder

class MultiSelectionItemViewHolder(
    binding: ItemMultiSelectionBinding,
    navigator: SelectionItemNavigator
) : BaseViewHolder<SelectionItem, ItemMultiSelectionBinding>(binding = binding, bindingVariable = BR.model) {

    init {
        binding.checkbox.setOnCheckedChangeListener { _, value ->
            if (adapterPosition != -1) {
                binding.model?.isSelected = value
                navigator.itemSelected(binding.model, adapterPosition)
            }
        }
    }

}