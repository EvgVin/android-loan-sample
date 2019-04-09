package com.evgvin.loan.ui.loan_purpose_detailed_steps.purpose_description

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class PurposeDescriptionFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(PurposeDescriptionViewModel::class)
    abstract fun provideViewModel(viewModel: PurposeDescriptionViewModel): ViewModel

}