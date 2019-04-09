package com.evgvin.loan.ui.registration_steps.choose_language

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class ChooseLanguageFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(ChooseLanguageViewModel::class)
    abstract fun provideViewModel(viewModel: ChooseLanguageViewModel): ViewModel

}