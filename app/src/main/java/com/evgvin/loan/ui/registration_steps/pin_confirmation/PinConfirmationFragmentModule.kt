package com.evgvin.loan.ui.registration_steps.pin_confirmation

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class PinConfirmationFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(PinConfirmationViewModel::class)
    abstract fun provideViewModel(viewModel: PinConfirmationViewModel): ViewModel

}