package com.evgvin.loan.ui.verification_steps

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey
import com.evgvin.loan.di.module.VerificationStepBuildersModule
import com.evgvin.loan.ui.steps_container.StepsContainerFragment
import com.evgvin.loan.ui.steps_container.StepsContainerViewModel

@Module(includes = [VerificationStepBuildersModule::class])
abstract class VerificationStepsFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(VerificationStepsViewModel::class)
    abstract fun provideViewModel(viewModel: VerificationStepsViewModel): ViewModel

    @Binds
    abstract fun provideStepsContainerFragment(
        fragment: VerificationStepsFragment
    ): StepsContainerFragment<out StepsContainerViewModel, out ViewDataBinding>

}