package com.evgvin.loan.ui.verification_steps.home_address

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class HomeAddressFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeAddressViewModel::class)
    abstract fun provideViewModel(viewModel: HomeAddressViewModel): ViewModel

}