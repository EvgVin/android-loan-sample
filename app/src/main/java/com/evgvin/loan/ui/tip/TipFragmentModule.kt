package com.evgvin.loan.ui.tip

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class TipFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(TipViewModel::class)
    abstract fun provideViewModel(viewModel: TipViewModel): ViewModel

}