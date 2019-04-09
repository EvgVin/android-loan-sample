package com.evgvin.loan.ui.home.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.evgvin.loan.BR
import com.evgvin.loan.data.model.Message
import com.evgvin.loan.databinding.ItemChatMessageManagerBinding
import com.evgvin.loan.databinding.ItemChatMessageSelfBinding
import com.evgvin.loan.ui.base.BaseRecyclerAdapter
import com.evgvin.loan.ui.base.BaseViewHolder

class ChatAdapter : BaseRecyclerAdapter<Message, ViewDataBinding>() {

    enum class Type {
        SELF,
        MANAGER
    }

    override fun getItemViewType(position: Int): Int {
        return if (items.get(position).isSelf) Type.SELF.ordinal else Type.MANAGER.ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Message, ViewDataBinding> {
        val itemViewBinding: ViewDataBinding

        when (viewType) {
            Type.SELF.ordinal -> {
                itemViewBinding = ItemChatMessageSelfBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
            }
            else -> {
                itemViewBinding = ItemChatMessageManagerBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
            }
        }

        return BaseViewHolder(binding = itemViewBinding, bindingVariable = BR.model)
    }

}