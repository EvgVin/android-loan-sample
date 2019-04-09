package com.evgvin.loan.ui.registration_steps

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey
import com.evgvin.loan.di.module.RegistrationStepBuildersModule
import com.evgvin.loan.ui.steps_container.StepsContainerFragment
import com.evgvin.loan.ui.steps_container.StepsContainerViewModel

@Module(includes = [RegistrationStepBuildersModule::class])
abstract class RegistrationStepsFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(RegistrationStepsViewModel::class)
    abstract fun provideViewModel(viewModel: RegistrationStepsViewModel): ViewModel

    @Binds
    abstract fun provideStepsContainerFragment(
        fragment: RegistrationStepsFragment
    ): StepsContainerFragment<out StepsContainerViewModel, out ViewDataBinding>

}