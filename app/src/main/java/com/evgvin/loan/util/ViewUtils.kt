package com.evgvin.loan.util

import android.view.View
import android.widget.PopupWindow
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.evgvin.loan.BR
import com.evgvin.loan.R
import com.evgvin.loan.ui.base.BaseItemNavigator
import com.evgvin.loan.ui.base.BaseRecyclerAdapter

fun View.showSnackbar(snackbarText: String, timeLength: Int) {
    Snackbar.make(this, snackbarText, timeLength).show()
}

fun NavController.canNavigateUp(): Boolean {
    val currentDestinationId = currentDestination?.id;
    val parentStartDestination = currentDestination?.parent?.startDestination
    return currentDestinationId != parentStartDestination
}

fun <T> View.showPopupWindow(
    items: List<T>,
    navigator: BaseItemNavigator<T>,
    @LayoutRes itemLayoutRes: Int = R.layout.item_base,
    bindingVariable: Int = BR.name
): PopupWindow {
    return PopupWindow(context).apply {
        val rvItems = RecyclerView(context).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = BaseRecyclerAdapter<T, ViewDataBinding>(itemLayoutRes, bindingVariable, navigator).apply {
                refreshList(items)
            }
        }

        contentView = rvItems
        width = this@showPopupWindow.width
        isFocusable = true

        showAsDropDown(this@showPopupWindow)
    }
}