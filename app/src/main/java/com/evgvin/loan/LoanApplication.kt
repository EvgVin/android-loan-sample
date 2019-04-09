package com.evgvin.loan

import android.app.Activity
import androidx.multidex.MultiDexApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import com.evgvin.loan.data.local.PreferenceManager
import com.evgvin.loan.di.component.DaggerAppComponent
import com.evgvin.loan.ui.base.BaseActivity
import javax.inject.Inject

class LoanApplication : MultiDexApplication(), HasActivityInjector {

    /**
     * Needs for locale initialization only.
     * Implementation in [BaseActivity.attachBaseContext]
     */
    companion object {
        lateinit var instance: LoanApplication private set
    }

    /**
     * Restores all values in [PreferenceManager] at the same time.
     */
    @Inject
    lateinit var preferenceManager: PreferenceManager

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = activityDispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()

        instance = this

        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

}