package com.evgvin.loan.ui.verification_steps.working_period

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class WorkingPeriodFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(WorkingPeriodViewModel::class)
    abstract fun provideViewModel(viewModel: WorkingPeriodViewModel): ViewModel

}