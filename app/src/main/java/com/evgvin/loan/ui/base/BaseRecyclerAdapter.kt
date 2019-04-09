package com.evgvin.loan.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class BaseRecyclerAdapter<T, out V : ViewDataBinding>(
    @LayoutRes
    val layoutRes: Int = -1,
    val bindingVariable: Int = -1,
    val navigator: BaseItemNavigator<T>? = null,
    val items: ArrayList<T> = ArrayList()
) : RecyclerView.Adapter<BaseViewHolder<T, ViewDataBinding>>() {

    /**
     * Used to pass not only position of the clicked item but and data item too.
     */
    protected val itemClick: (Int) -> Unit = { navigator?.itemClicked(items[it], it) }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T, ViewDataBinding> {
        val itemViewBinding = DataBindingUtil
            .inflate<V>(LayoutInflater.from(parent.context), layoutRes, parent, false)
        return BaseViewHolder(itemViewBinding, bindingVariable, itemClick)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T, ViewDataBinding>, position: Int) {
        holder.bind(items[position])
    }

    fun refreshList(newItems: List<T>) {
        items.clear()
        items += newItems
        notifyDataSetChanged()
    }

}