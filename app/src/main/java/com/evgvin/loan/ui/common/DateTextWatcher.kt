package com.evgvin.loan.ui.common

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * This [TextWatcher] adds needed symbols when user typing text.
 *
 * For example, the user must input a date with separators, such as "dd/mm/yyyy".
 * Separators will be added automatically when the user enters text.
 *
 * @param datePattern used for filtering user text.
 */
class DateTextWatcher constructor(private val datePattern: String, private val editText: EditText) : TextWatcher {

    var result = StringBuilder()
    var needToRemoveCount = 0

    override fun afterTextChanged(editable: Editable?) {}

    /**
     * Looking for and count all symbols to be deleted in [onTextChanged]
     */
    override fun beforeTextChanged(source: CharSequence?, start: Int, end: Int, count: Int) {
        if (!isEntering(count)) {
            val text = source ?: ""
            needToRemoveCount = 0
            for (symbol in text.reversed()) {
                // Ignore symbol if it's digit.
                if (symbol.isDigit()) break

                needToRemoveCount++
            }
        }
    }

    /**
     * Add the necessary symbols, if it is input.
     * Delete if it is clearing.
     */
    override fun onTextChanged(source: CharSequence?, start: Int, end: Int, count: Int) {
        if (source.toString() == result.toString()) return

        val text = source ?: ""
        result = StringBuilder()

        if (isEntering(count)) {
            var patternStartPos = 0
            if (text.length == 1) appendNeededSymbols(patternStartPos, result)
            result.append(text)
            patternStartPos = result.length
            appendNeededSymbols(patternStartPos, result)
        } else {
            val endPosition = text.length - needToRemoveCount
            if (text.length >= endPosition) result.append(text.substring(0, endPosition))
        }

        editText.apply {
            setText(result)
            setSelection(result.length)
        }
    }

    private fun isEntering(count: Int) = count != 0

    private fun appendNeededSymbols(patternStartPos: Int, text: StringBuilder) {
        if (patternStartPos >= datePattern.length) return
        for (symbol in datePattern.substring(patternStartPos)) {
            // No need to append symbol if it's letter.
            // In this case letter symbol in pattern is digit. Example: dd/mm/yyyy -> 12/11/2019
            if (symbol.isLetter()) break

            text.append(symbol)
        }
    }

}