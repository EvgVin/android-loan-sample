package com.evgvin.loan.data.model

import com.evgvin.loan.ui.item_selection_list.SelectionListFragment

/**
 * The class is used to output items in [SelectionListFragment]
 *
 * @param name       name of the selection item
 * @param isSelected state of the selection item (selected or not)
 */
data class SelectionItem(
    val name: String,
    var isSelected: Boolean = false
)