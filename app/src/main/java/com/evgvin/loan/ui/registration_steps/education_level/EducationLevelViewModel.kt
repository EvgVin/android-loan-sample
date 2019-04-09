package com.evgvin.loan.ui.registration_steps.education_level

import android.content.Context
import com.evgvin.loan.R
import com.evgvin.loan.ui.item_selection_list.SelectionListViewModel
import javax.inject.Inject

class EducationLevelViewModel @Inject constructor(context: Context) : SelectionListViewModel() {

    init {
        stringItems.value = context.resources.getStringArray(R.array.education_level_items)
    }

}