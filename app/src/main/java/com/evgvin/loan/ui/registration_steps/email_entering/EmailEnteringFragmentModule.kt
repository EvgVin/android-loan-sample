package com.evgvin.loan.ui.registration_steps.email_entering

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class EmailEnteringFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(EmailEnteringViewModel::class)
    abstract fun provideViewModel(viewModel: EmailEnteringViewModel): ViewModel

}