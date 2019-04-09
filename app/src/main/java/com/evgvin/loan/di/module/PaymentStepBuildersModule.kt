package com.evgvin.loan.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.evgvin.loan.ui.payment_steps.payment_amount.PaymentAmountFragment
import com.evgvin.loan.ui.payment_steps.payment_amount.PaymentAmountFragmentModule
import com.evgvin.loan.ui.payment_steps.payment_method.PaymentMethodFragment
import com.evgvin.loan.ui.payment_steps.payment_method.PaymentMethodFragmentModule

@Module
abstract class PaymentStepBuildersModule {

    @ContributesAndroidInjector(modules = [PaymentAmountFragmentModule::class])
    abstract fun contributePaymentAmountFragment(): PaymentAmountFragment

    @ContributesAndroidInjector(modules = [PaymentMethodFragmentModule::class])
    abstract fun contributePaymentMethodFragment(): PaymentMethodFragment

}