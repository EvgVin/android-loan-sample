package com.evgvin.loan.ui.registration_steps.phone_confirmation

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class PhoneConfirmationFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(PhoneConfirmationViewModel::class)
    abstract fun provideViewModel(viewModel: PhoneConfirmationViewModel): ViewModel

}