package com.evgvin.loan.ui.payment_steps

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey
import com.evgvin.loan.di.module.PaymentStepBuildersModule
import com.evgvin.loan.ui.steps_container.StepsContainerFragment
import com.evgvin.loan.ui.steps_container.StepsContainerViewModel

@Module(includes = [PaymentStepBuildersModule::class])
abstract class PaymentStepsFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(PaymentStepsViewModel::class)
    abstract fun provideViewModel(viewModel: PaymentStepsViewModel): ViewModel

    @Binds
    abstract fun provideStepsContainerFragment(
        fragment: PaymentStepsFragment
    ): StepsContainerFragment<out StepsContainerViewModel, out ViewDataBinding>

}