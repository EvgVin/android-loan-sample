package com.evgvin.loan.ui.home.chat

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.evgvin.loan.di.ViewModelKey

@Module
abstract class ChatFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(ChatViewModel::class)
    abstract fun provideViewModel(viewModel: ChatViewModel): ViewModel

}