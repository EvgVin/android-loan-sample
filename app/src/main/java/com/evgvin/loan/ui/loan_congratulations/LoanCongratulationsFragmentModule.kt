package com.evgvin.loan.ui.loan_congratulations

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class LoanCongratulationsFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoanCongratulationsViewModel::class)
    abstract fun provideViewModel(viewModel: LoanCongratulationsViewModel): ViewModel

}