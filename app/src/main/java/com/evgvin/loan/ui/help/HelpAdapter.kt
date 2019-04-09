package com.evgvin.loan.ui.help

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.evgvin.loan.data.model.Help
import com.evgvin.loan.databinding.ItemHelpBinding
import com.evgvin.loan.ui.base.BaseRecyclerAdapter
import com.evgvin.loan.ui.base.BaseViewHolder

class HelpAdapter() : BaseRecyclerAdapter<Help, ViewDataBinding>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Help, ViewDataBinding> {
        val itemViewBinding = ItemHelpBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return HelpItemViewHolder(itemViewBinding)
    }

}