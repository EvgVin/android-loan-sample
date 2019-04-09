package com.evgvin.loan.ui.verification_steps.work_address

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class WorkAddressFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(WorkAddressViewModel::class)
    abstract fun provideViewModel(viewModel: WorkAddressViewModel): ViewModel

}