package com.evgvin.loan.ui.loan_purpose_detailed_steps.outstanding_loans

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class OutstandingLoansFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(OutstandingLoansViewModel::class)
    abstract fun provideViewModel(viewModel: OutstandingLoansViewModel): ViewModel

}