package com.evgvin.loan.ui.base

import androidx.annotation.CallSuper
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Base [RecyclerView.ViewHolder] class.
 *
 * @param binding         view data binding
 * @param bindingVariable binding variable of the model
 * @param itemClick       used to transfer the clicked item position in adapter
 */
open class BaseViewHolder<T, out V : ViewDataBinding>(
    val binding: V,
    val bindingVariable: Int,
    itemClick: (Int) -> Unit = {}
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            if (adapterPosition != -1) itemClick(adapterPosition)
        }
    }

    @CallSuper
    open fun bind(data: T) {
        binding.setVariable(bindingVariable, data)
        binding.executePendingBindings()
    }

}