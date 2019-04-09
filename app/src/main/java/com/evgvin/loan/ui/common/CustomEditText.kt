package com.evgvin.loan.ui.common

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.util.AttributeSet
import androidx.core.view.ViewCompat
import com.google.android.material.textfield.TextInputEditText
import com.evgvin.loan.R

/**
 * Custom [TextInputEditText] is used to display the prefix before a text.
 *
 * Phone number example: +38 0951234567.
 * +380 - is the static prefix and 951234567 - is the phone number entered by the user.
 */
class CustomEditText(context: Context, attrs: AttributeSet) : TextInputEditText(context, attrs) {

    private var prefix: String = ""
    private val prefixRect = Rect()

    private var startPadding: Int = 0
    private var endPadding: Int = 0

    init {
        val typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomEditText)
        prefix = typedArray.getString(R.styleable.CustomEditText_prefix) ?: ""
        startPadding = typedArray.getDimensionPixelOffset(R.styleable.CustomEditText_prefixPaddingStart, 0)
        endPadding = typedArray.getDimensionPixelOffset(R.styleable.CustomEditText_prefixPaddingEnd, 0)
        typedArray.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        paint.getTextBounds(prefix, 0, prefix.length, prefixRect)

        if (isLtrLayoutDirection()) {
            prefixRect.left += startPadding
            prefixRect.right += endPadding
        } else {
            prefixRect.right += startPadding
            prefixRect.left += endPadding
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawText(prefix, super.getCompoundPaddingLeft().toFloat(), baseline.toFloat(), paint)
    }

    override fun getCompoundPaddingLeft(): Int {
        return super.getCompoundPaddingLeft() + prefixRect.width()
    }

    private fun isLtrLayoutDirection() = ViewCompat.getLayoutDirection(this) == ViewCompat.LAYOUT_DIRECTION_LTR

}