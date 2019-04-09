package com.evgvin.loan.ui.common

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

/**
 * Custom [ViewPager] with swipe disabling feature.
 */
class CustomViewPager @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ViewPager(context, attrs) {

    var swipeEnabled = true

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (swipeEnabled) {
            super.onTouchEvent(event)
        } else {
            false
        }

    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return if (swipeEnabled) {
            super.onInterceptTouchEvent(event)
        } else {
            false
        }

    }
}