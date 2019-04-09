package com.evgvin.loan.ui.welcome

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class WelcomeFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(WelcomeViewModel::class)
    abstract fun provideViewModel(viewModel: WelcomeViewModel): ViewModel

}