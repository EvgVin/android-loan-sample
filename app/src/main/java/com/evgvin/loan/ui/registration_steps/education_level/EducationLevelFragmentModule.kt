package com.evgvin.loan.ui.registration_steps.education_level

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class EducationLevelFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(EducationLevelViewModel::class)
    abstract fun provideViewModel(viewModel: EducationLevelViewModel): ViewModel

}