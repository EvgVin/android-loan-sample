package com.evgvin.loan.ui.languages

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class LanguagesFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(LanguagesViewModel::class)
    abstract fun provideViewModel(viewModel: LanguagesViewModel): ViewModel

}