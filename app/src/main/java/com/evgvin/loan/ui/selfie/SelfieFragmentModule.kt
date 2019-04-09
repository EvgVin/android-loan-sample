package com.evgvin.loan.ui.selfie

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class SelfieFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(SelfieViewModel::class)
    abstract fun provideViewModel(viewModel: SelfieViewModel): ViewModel

}