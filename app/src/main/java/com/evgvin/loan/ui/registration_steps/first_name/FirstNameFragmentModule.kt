package com.evgvin.loan.ui.registration_steps.first_name

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class FirstNameFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(FirstNameViewModel::class)
    abstract fun provideViewModel(viewModel: FirstNameViewModel): ViewModel

}