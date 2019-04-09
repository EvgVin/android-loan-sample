package com.evgvin.loan.di.module

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import com.evgvin.loan.Constants
import com.evgvin.loan.data.local.PreferenceManager
import com.evgvin.loan.data.remote.LoanApi
import com.evgvin.loan.ui.base.BaseViewModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideBeyondApi(): LoanApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit.create(LoanApi::class.java)
    }

    @Provides
    @Singleton
    fun providePreferenceManager(context: Context): PreferenceManager {
        return PreferenceManager(context)
    }

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    fun provideViewModelProviderFactory(factory: BaseViewModelFactory): ViewModelProvider.Factory {
        return factory
    }

}