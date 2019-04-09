package com.evgvin.loan.ui.verification_steps.date_of_birth

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class DateOfBirthFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(DateOfBirthViewModel::class)
    abstract fun provideViewModel(viewModel: DateOfBirthViewModel): ViewModel

}