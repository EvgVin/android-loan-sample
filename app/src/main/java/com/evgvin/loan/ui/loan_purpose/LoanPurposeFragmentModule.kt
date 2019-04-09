package com.evgvin.loan.ui.loan_purpose

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class LoanPurposeFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoanPurposeViewModel::class)
    abstract fun provideViewModel(viewModel: LoanPurposeViewModel): ViewModel

}