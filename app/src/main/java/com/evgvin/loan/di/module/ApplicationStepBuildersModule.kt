package com.evgvin.loan.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.evgvin.loan.ui.application_steps.single_selection.SingleSelectionFragment
import com.evgvin.loan.ui.application_steps.single_selection.SingleSelectionFragmentModule

@Module
abstract class ApplicationStepBuildersModule {

    @ContributesAndroidInjector(modules = [SingleSelectionFragmentModule::class])
    abstract fun contributeSingleSelectionFragment(): SingleSelectionFragment

}