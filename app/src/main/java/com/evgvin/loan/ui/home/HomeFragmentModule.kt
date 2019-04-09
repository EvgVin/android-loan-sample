package com.evgvin.loan.ui.home

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey
import com.evgvin.loan.di.module.HomeBuildersModule

@Module(includes = [HomeBuildersModule::class])
abstract class HomeFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun provideViewModel(viewModel: HomeViewModel): ViewModel

}