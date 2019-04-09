package com.evgvin.loan.ui.payment_steps.payment_method

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class PaymentMethodFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(PaymentMethodViewModel::class)
    abstract fun provideViewModel(viewModel: PaymentMethodViewModel): ViewModel

}