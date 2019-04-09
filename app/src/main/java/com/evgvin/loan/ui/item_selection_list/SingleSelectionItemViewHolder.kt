package com.evgvin.loan.ui.item_selection_list

import com.evgvin.loan.BR
import com.evgvin.loan.data.model.SelectionItem
import com.evgvin.loan.databinding.ItemSingleSelectionBinding
import com.evgvin.loan.ui.base.BaseViewHolder

class SingleSelectionItemViewHolder(
    binding: ItemSingleSelectionBinding,
    navigator: SelectionItemNavigator
) : BaseViewHolder<SelectionItem, ItemSingleSelectionBinding>(binding = binding, bindingVariable = BR.model) {

    init {
        binding.radioButton.setOnCheckedChangeListener { _, value ->
            if (adapterPosition != -1 && binding.model?.isSelected != value) {
                binding.model?.isSelected = value
                navigator.itemSelected(binding.model, adapterPosition)
            }
        }
    }

}