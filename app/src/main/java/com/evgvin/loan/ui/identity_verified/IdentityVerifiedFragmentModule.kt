package com.evgvin.loan.ui.identity_verified

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class IdentityVerifiedFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(IdentityVerifiedViewModel::class)
    abstract fun provideViewModel(viewModel: IdentityVerifiedViewModel): ViewModel

}