package com.evgvin.loan.ui.main

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey
import com.evgvin.loan.di.module.MainBuildersModule

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = [MainBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun provideViewModel(viewModel: MainViewModel): ViewModel

}