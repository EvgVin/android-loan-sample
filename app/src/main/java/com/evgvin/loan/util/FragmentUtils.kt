package com.evgvin.loan.util

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.annotation.ColorRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.evgvin.loan.R

fun Fragment.initArguments(args: Bundle?): Fragment {
    this.arguments = args
    return this
}

fun Fragment.setupActionBar(toolbar: Toolbar, setupWithNavController: Boolean = true, action: ActionBar.() -> Unit) {
    with(activity as AppCompatActivity) {
        setSupportActionBar(toolbar)
        if (setupWithNavController) NavigationUI.setupWithNavController(toolbar, findNavController())
        supportActionBar?.run {
            action()
        }
    }
}

fun Fragment.getColor(@ColorRes colorRes: Int): Int {
    return ContextCompat.getColor(context ?: throw NullPointerException("Context is null"), colorRes)
}

fun <T> Fragment.setupArrayAdapter(): ArrayAdapter<T> {
    return ArrayAdapter(context, R.layout.item_base)
}