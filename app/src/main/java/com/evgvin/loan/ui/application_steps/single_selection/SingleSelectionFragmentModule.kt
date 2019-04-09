package com.evgvin.loan.ui.application_steps.single_selection

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class SingleSelectionFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(SingleSelectionViewModel::class)
    abstract fun provideViewModel(viewModel: SingleSelectionViewModel): ViewModel

}