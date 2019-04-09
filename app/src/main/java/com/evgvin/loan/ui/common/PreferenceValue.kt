package com.evgvin.loan.ui.common

import android.content.SharedPreferences
import com.evgvin.loan.data.local.PreferenceManager
import com.evgvin.loan.ui.base.BasePreferenceManager
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * This class is used to manage [PreferenceManager] values.
 *
 * It helps to significantly simplify the saving and restoring
 * of the necessary value from [SharedPreferences].
 */
class PreferenceValue<T : Any>(
    sharedPreferences: SharedPreferences,
    clazz: Class<T>,
    defaultValue: T,
    private val key: String
) : ReadWriteProperty<BasePreferenceManager, T> {
    private var _value: T

    init {
        @Suppress("UNCHECKED_CAST")
        _value = sharedPreferences.getValue(clazz, key, defaultValue) as? T
            ?: throw IllegalArgumentException("Class T can't be casted to $clazz")
    }

    override fun getValue(thisRef: BasePreferenceManager, property: KProperty<*>): T {
        return _value
    }

    override fun setValue(thisRef: BasePreferenceManager, property: KProperty<*>, value: T) {
        _value = value
        thisRef.getPreferences().edit().apply {
            putValue(key, value)
            apply()
        }
    }

}

inline fun <reified T : Any> BasePreferenceManager.setupValue(
    key: String,
    defaultValue: T
) = PreferenceValue(getPreferences(), T::class.java, defaultValue, key)

fun <T : Any> SharedPreferences.getValue(clazz: Class<T>, key: String, defaultValue: T): Any {
    return when (defaultValue) {
        is String -> getString(key, defaultValue)
        is Boolean -> getBoolean(key, defaultValue)
        is Int -> getInt(key, defaultValue)
        is Long -> getLong(key, defaultValue)
        is Float -> getFloat(key, defaultValue)
        else -> throw IllegalArgumentException("Current class type is not supported: $clazz")
    }
}

fun <T : Any> SharedPreferences.Editor.putValue(key: String, value: T) {
    when (value) {
        is String -> putString(key, value)
        is Boolean -> putBoolean(key, value)
        is Int -> putInt(key, value)
        is Long -> putLong(key, value)
        is Float -> putFloat(key, value)
        else -> throw IllegalArgumentException("Current class type is not supported")
    }
}