package com.evgvin.loan.ui.verification_steps.working_period

import android.content.Context
import com.evgvin.loan.R
import com.evgvin.loan.ui.item_selection_list.SelectionListViewModel
import javax.inject.Inject

class WorkingPeriodViewModel @Inject constructor(context: Context) : SelectionListViewModel() {

    init {
        stringItems.value = context.resources.getStringArray(R.array.working_period_items)
    }

}