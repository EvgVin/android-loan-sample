package com.evgvin.loan.ui.application_intro

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class ApplicationIntroFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(ApplicationIntroViewModel::class)
    abstract fun provideViewModel(viewModel: ApplicationIntroViewModel): ViewModel

}