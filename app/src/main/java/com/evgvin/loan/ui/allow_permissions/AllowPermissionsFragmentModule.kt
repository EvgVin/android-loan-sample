package com.evgvin.loan.ui.allow_permissions

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class AllowPermissionsFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(AllowPermissionsViewModel::class)
    abstract fun provideViewModel(viewModel: AllowPermissionsViewModel): ViewModel

}