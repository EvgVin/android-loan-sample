package com.evgvin.loan.ui.base

import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import android.os.Bundle
import android.os.LocaleList
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import com.evgvin.loan.LoanApplication
import java.util.*
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun attachBaseContext(context: Context) {
        // [currentLocaleCode] restores through [Application] because we can't inject anything at this moment.
        val newLocaleCode = LoanApplication.instance.preferenceManager.currentLocaleCode
        val newContext = changeLocale(context, newLocaleCode)
        super.attachBaseContext(newContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector

    private fun changeLocale(context: Context, localeCode: String): ContextWrapper {
        val configuration = context.resources.configuration
        val newLocale = Locale(localeCode)
        val newContext: Context

        if (Build.VERSION.SDK_INT >= 24) {
            configuration.setLocale(newLocale)

            val localeList = LocaleList(newLocale)
            LocaleList.setDefault(localeList)
            configuration.locales = localeList

            newContext = context.createConfigurationContext(configuration)
        } else {
            configuration.setLocale(newLocale)
            newContext = context.createConfigurationContext(configuration)
        }
        return ContextWrapper(newContext)
    }

}
