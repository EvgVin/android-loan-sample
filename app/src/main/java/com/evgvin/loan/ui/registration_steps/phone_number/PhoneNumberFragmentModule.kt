package com.evgvin.loan.ui.registration_steps.phone_number

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class PhoneNumberFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(PhoneNumberViewModel::class)
    abstract fun provideViewModel(viewModel: PhoneNumberViewModel): ViewModel

}