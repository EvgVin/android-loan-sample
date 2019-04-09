package com.evgvin.loan.util

import android.content.ContentResolver
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.util.Patterns
import android.util.TypedValue
import androidx.annotation.AttrRes
import java.text.SimpleDateFormat
import java.util.*

object Utils {

    @JvmStatic
    val PHONE_LENGTH = 10

    @JvmStatic
    val EMAIL_LENGTH = 100

    @JvmStatic
    val NAME_LENGTH = 100

    fun isEmailValid(email: CharSequence): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isPhoneValid(phone: CharSequence): Boolean {
        return phone.length >= PHONE_LENGTH && Patterns.PHONE.matcher(phone).matches()
    }

    fun isNameValid(name: CharSequence): Boolean {
        return name.matches("[A-Za-z]+".toRegex())
    }

    fun isDateValid(date: String, pattern: String): Boolean {
        if (date.length < pattern.length) return false
        val dateFormat = SimpleDateFormat(pattern, Locale.getDefault())
        dateFormat.isLenient = false
        return try {
            dateFormat.parse(date)
            true
        } catch (e: Exception) {
            false
        }
    }

}

fun Context.getResourceFromTheme(@AttrRes attr: Int): Int {
    val typedValue = TypedValue()
    theme.resolveAttribute(attr, typedValue, true)
    return typedValue.resourceId
}

inline fun <T> ContentResolver.getData(
    uri: Uri,
    projection: Array<String>? = null,
    selection: String? = null,
    selectionArgs: Array<String>? = null,
    sortOrder: String? = null,
    action: (Cursor) -> T
): List<T> {
    val dataList = ArrayList<T>()
    query(uri, projection, selection, selectionArgs, sortOrder).use {
        if (it == null) return@use
        if (it.moveToFirst()) {
            for (i in 0 until it.count) {
                dataList += action(it)
                it.moveToNext()
            }
        }
    }
    return dataList
}