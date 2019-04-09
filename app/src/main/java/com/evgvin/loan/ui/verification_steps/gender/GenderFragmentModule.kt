package com.evgvin.loan.ui.verification_steps.gender

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class GenderFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(GenderViewModel::class)
    abstract fun provideViewModel(viewModel: GenderViewModel): ViewModel

}