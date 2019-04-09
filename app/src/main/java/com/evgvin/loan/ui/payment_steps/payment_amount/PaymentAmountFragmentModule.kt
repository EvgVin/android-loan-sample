package com.evgvin.loan.ui.payment_steps.payment_amount

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class PaymentAmountFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(PaymentAmountViewModel::class)
    abstract fun provideViewModel(viewModel: PaymentAmountViewModel): ViewModel

}