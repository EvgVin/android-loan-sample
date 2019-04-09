package com.evgvin.loan.ui.loan_purpose_detailed_steps

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey
import com.evgvin.loan.di.module.LoanPurposeBuildersModule
import com.evgvin.loan.ui.steps_container.StepsContainerFragment
import com.evgvin.loan.ui.steps_container.StepsContainerViewModel

@Module(includes = [LoanPurposeBuildersModule::class])
abstract class LoanPurposeDetailedFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoanPurposeDetailedStepsViewModel::class)
    abstract fun provideViewModel(stepsViewModel: LoanPurposeDetailedStepsViewModel): ViewModel

    @Binds
    abstract fun provideStepsContainerFragment(
        fragment: LoanPurposeDetailedStepsFragment
    ): StepsContainerFragment<out StepsContainerViewModel, out ViewDataBinding>

}