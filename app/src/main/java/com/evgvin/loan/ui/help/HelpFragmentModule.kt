package com.evgvin.loan.ui.help

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class HelpFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(HelpViewModel::class)
    abstract fun provideViewModel(viewModel: HelpViewModel): ViewModel

}