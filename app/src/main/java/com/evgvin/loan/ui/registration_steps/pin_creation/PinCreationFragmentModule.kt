package com.evgvin.loan.ui.registration_steps.pin_creation

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class PinCreationFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(PinCreationViewModel::class)
    abstract fun provideViewModel(viewModel: PinCreationViewModel): ViewModel

}