package com.evgvin.loan.ui.loan_purpose_detailed_steps.outstanding_loans

import android.content.Context
import com.evgvin.loan.R
import com.evgvin.loan.ui.item_selection_list.SelectionListViewModel
import javax.inject.Inject

class OutstandingLoansViewModel @Inject constructor(context: Context) : SelectionListViewModel() {

    init {
        stringItems.value = context.resources.getStringArray(R.array.outstanding_loan_items)
    }

}