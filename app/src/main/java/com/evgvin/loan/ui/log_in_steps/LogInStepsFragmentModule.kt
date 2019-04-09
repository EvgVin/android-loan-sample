package com.evgvin.loan.ui.log_in_steps

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey
import com.evgvin.loan.di.module.LogInStepBuildersModule
import com.evgvin.loan.ui.steps_container.StepsContainerFragment
import com.evgvin.loan.ui.steps_container.StepsContainerViewModel

@Module(includes = [LogInStepBuildersModule::class])
abstract class LogInStepsFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(LogInStepsViewModel::class)
    abstract fun provideViewModel(viewModel: LogInStepsViewModel): ViewModel

    @Binds
    abstract fun provideStepsContainerFragment(
        fragment: LogInStepsFragment
    ): StepsContainerFragment<out StepsContainerViewModel, out ViewDataBinding>

}