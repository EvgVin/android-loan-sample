package com.evgvin.loan.ui.registration_steps.employment

import android.content.Context
import com.evgvin.loan.R
import com.evgvin.loan.ui.item_selection_list.SelectionListViewModel
import javax.inject.Inject

class EmploymentViewModel @Inject constructor(context: Context) : SelectionListViewModel() {

    init {
        stringItems.value = context.resources.getStringArray(R.array.employment_items)
    }

}