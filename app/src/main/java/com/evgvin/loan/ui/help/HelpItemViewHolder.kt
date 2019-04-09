package com.evgvin.loan.ui.help

import com.evgvin.loan.BR
import com.evgvin.loan.data.model.Help
import com.evgvin.loan.databinding.ItemHelpBinding
import com.evgvin.loan.ui.base.BaseViewHolder

class HelpItemViewHolder(
    binding: ItemHelpBinding
) : BaseViewHolder<Help, ItemHelpBinding>(binding = binding, bindingVariable = BR.model) {

    val ARROW_ROTATION = 180f

    init {
        binding.root.setOnClickListener {
            if (adapterPosition != -1) {
                binding.apply {
                    val isExpanded = expandableAnswer.isExpanded
                    ivArrow.animate().rotation(if (isExpanded) 0f else ARROW_ROTATION).start()
                    expandableAnswer.toggle()
                }
            }
        }
    }

}