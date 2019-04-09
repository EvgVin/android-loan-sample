package com.evgvin.loan.ui.base

import android.content.SharedPreferences

interface BasePreferenceManager {

    fun getPreferences(): SharedPreferences

}