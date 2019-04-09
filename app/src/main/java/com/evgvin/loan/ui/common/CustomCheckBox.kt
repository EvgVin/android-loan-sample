package com.evgvin.loan.ui.common

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.core.content.res.ResourcesCompat
import com.evgvin.loan.R
import com.evgvin.loan.util.getResourceFromTheme

class CustomCheckBox(context: Context, attrs: AttributeSet) : AppCompatCheckBox(context, attrs) {

    /**
     * Solution to solve [AppCompatCheckBox] issue with custom font applying.
     */
    init {
        typeface = ResourcesCompat.getFont(context, context.getResourceFromTheme(R.attr.fontFamily));
    }

}