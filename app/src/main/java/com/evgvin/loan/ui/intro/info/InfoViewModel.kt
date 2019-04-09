package com.evgvin.loan.ui.intro.info

import androidx.databinding.ObservableInt
import com.evgvin.loan.ui.base.BaseViewModel
import javax.inject.Inject

class InfoViewModel @Inject constructor() : BaseViewModel() {

    val title = ObservableInt()
    val description = ObservableInt()

}