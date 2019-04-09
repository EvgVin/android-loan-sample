package com.evgvin.loan.data.local

import android.content.Context
import android.content.SharedPreferences
import com.evgvin.loan.ui.base.BasePreferenceManager
import com.evgvin.loan.ui.common.setupValue

/**
 * [PreferenceManager] is used to store all needed settings, params etc.
 */
class PreferenceManager(private val context: Context) : BasePreferenceManager {

    private val DEFAULT_PREF = "Default"

    private val LOCALE = "Locale"

    var currentLocaleCode: String by setupValue(LOCALE, "")

    override fun getPreferences(): SharedPreferences = context.getSharedPreferences(DEFAULT_PREF, Context.MODE_PRIVATE)

}