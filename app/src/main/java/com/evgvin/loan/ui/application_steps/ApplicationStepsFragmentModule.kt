package com.evgvin.loan.ui.application_steps

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey
import com.evgvin.loan.di.module.ApplicationStepBuildersModule
import com.evgvin.loan.ui.steps_container.StepsContainerFragment
import com.evgvin.loan.ui.steps_container.StepsContainerViewModel

@Module(includes = [ApplicationStepBuildersModule::class])
abstract class ApplicationStepsFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(ApplicationStepsViewModel::class)
    abstract fun provideViewModel(viewModel: ApplicationStepsViewModel): ViewModel

    @Binds
    abstract fun provideStepsContainerFragment(
        fragment: ApplicationStepsFragment
    ): StepsContainerFragment<out StepsContainerViewModel, out ViewDataBinding>

}