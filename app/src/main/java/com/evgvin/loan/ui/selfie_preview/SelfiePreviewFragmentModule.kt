package com.evgvin.loan.ui.selfie_preview

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class SelfiePreviewFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(SelfiePreviewViewModel::class)
    abstract fun provideViewModel(viewModel: SelfiePreviewViewModel): ViewModel

}