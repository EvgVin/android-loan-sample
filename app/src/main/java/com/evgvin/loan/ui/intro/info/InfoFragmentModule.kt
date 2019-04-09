package com.evgvin.loan.ui.intro.info

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
class InfoFragmentModule {

    @Provides
    @IntoMap
    @ViewModelKey(InfoViewModel::class)
    fun provideViewModel(viewModel: InfoViewModel): ViewModel {
        return viewModel
    }

}