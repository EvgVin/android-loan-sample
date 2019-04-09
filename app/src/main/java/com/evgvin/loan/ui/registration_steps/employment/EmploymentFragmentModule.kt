package com.evgvin.loan.ui.registration_steps.employment

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class EmploymentFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(EmploymentViewModel::class)
    abstract fun provideViewModel(viewModel: EmploymentViewModel): ViewModel

}