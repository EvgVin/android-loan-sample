package com.evgvin.loan.ui.verification_steps.occupation

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class OccupationFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(OccupationViewModel::class)
    abstract fun provideViewModel(viewModel: OccupationViewModel): ViewModel

}