package com.evgvin.loan.ui.item_selection_list

import com.evgvin.loan.data.model.SelectionItem

interface SelectionItemNavigator {

    fun itemSelected(item: SelectionItem?, position: Int)

}