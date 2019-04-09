package com.evgvin.loan.ui.intro

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey
import com.evgvin.loan.ui.intro.info.InfoFragment
import com.evgvin.loan.ui.intro.info.InfoFragmentModule

@Module
abstract class IntroFragmentModule {

    @ContributesAndroidInjector(modules = [InfoFragmentModule::class])
    abstract fun contributeInfoFragment(): InfoFragment

    @Binds
    @IntoMap
    @ViewModelKey(IntroViewModel::class)
    abstract fun provideViewModel(viewModel: IntroViewModel): ViewModel

}