package com.evgvin.loan.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.evgvin.loan.ui.home.chat.ChatFragment
import com.evgvin.loan.ui.home.chat.ChatFragmentModule
import com.evgvin.loan.ui.home.feed.FeedFragment
import com.evgvin.loan.ui.home.feed.FeedFragmentModule
import com.evgvin.loan.ui.home.profile.ProfileFragment
import com.evgvin.loan.ui.home.profile.ProfileFragmentModule

@Module
abstract class HomeBuildersModule {

    @ContributesAndroidInjector(modules = [ChatFragmentModule::class])
    abstract fun contributeChatFragment(): ChatFragment

    @ContributesAndroidInjector(modules = [FeedFragmentModule::class])
    abstract fun contributeFeedFragment(): FeedFragment

    @ContributesAndroidInjector(modules = [ProfileFragmentModule::class])
    abstract fun contributeProfileFragment(): ProfileFragment

}