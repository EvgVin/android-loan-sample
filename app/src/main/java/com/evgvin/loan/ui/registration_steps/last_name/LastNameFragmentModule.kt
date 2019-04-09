package com.evgvin.loan.ui.registration_steps.last_name

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class LastNameFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(LastNameViewModel::class)
    abstract fun provideViewModel(viewModel: LastNameViewModel): ViewModel

}