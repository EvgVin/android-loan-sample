package com.evgvin.loan.ui.common

import android.text.InputFilter
import android.text.Spanned

/**
 * The [InputFilter] class is used to filter characters when the user entering date.
 *
 * @param datePattern pattern of the date format
 */
class DateInputFilter constructor(private val datePattern: String) : InputFilter {

    private val allowedSeparators: List<Char> by lazy {
        ArrayList<Char>().apply {
            for (symbol in datePattern) {
                if (symbol.isLetter()) continue
                add(symbol)
            }
        }
    }

    override fun filter(source: CharSequence?, start: Int, end: Int, dest: Spanned?, destStart: Int, destEnd: Int): CharSequence {
        source?.let {
            if (dest?.length ?: 0 >= datePattern.length) return ""
            if (source.isEmpty()) return source
            val symbol = source.elementAt(0)
            return if (symbol.isDigit() || allowedSeparators.contains(symbol)) {
                source
            } else {
                ""
            }
        }
        return ""
    }

}