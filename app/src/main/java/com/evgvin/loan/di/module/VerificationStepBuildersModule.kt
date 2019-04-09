package com.evgvin.loan.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.evgvin.loan.ui.verification_steps.date_of_birth.DateOfBirthFragment
import com.evgvin.loan.ui.verification_steps.date_of_birth.DateOfBirthFragmentModule
import com.evgvin.loan.ui.verification_steps.gender.GenderFragment
import com.evgvin.loan.ui.verification_steps.gender.GenderFragmentModule
import com.evgvin.loan.ui.verification_steps.home_address.HomeAddressFragment
import com.evgvin.loan.ui.verification_steps.home_address.HomeAddressFragmentModule
import com.evgvin.loan.ui.verification_steps.occupation.OccupationFragment
import com.evgvin.loan.ui.verification_steps.occupation.OccupationFragmentModule
import com.evgvin.loan.ui.verification_steps.work_address.WorkAddressFragment
import com.evgvin.loan.ui.verification_steps.work_address.WorkAddressFragmentModule
import com.evgvin.loan.ui.verification_steps.working_period.WorkingPeriodFragment
import com.evgvin.loan.ui.verification_steps.working_period.WorkingPeriodFragmentModule

@Module
abstract class VerificationStepBuildersModule {

    @ContributesAndroidInjector(modules = [DateOfBirthFragmentModule::class])
    abstract fun contributeDateOfBirthFragment(): DateOfBirthFragment

    @ContributesAndroidInjector(modules = [GenderFragmentModule::class])
    abstract fun contributeGenderFragment(): GenderFragment

    @ContributesAndroidInjector(modules = [HomeAddressFragmentModule::class])
    abstract fun contributeHomeAddressFragment(): HomeAddressFragment

    @ContributesAndroidInjector(modules = [OccupationFragmentModule::class])
    abstract fun contributeOccupationFragment(): OccupationFragment

    @ContributesAndroidInjector(modules = [WorkAddressFragmentModule::class])
    abstract fun contributeWorkAddressFragment(): WorkAddressFragment

    @ContributesAndroidInjector(modules = [WorkingPeriodFragmentModule::class])
    abstract fun contributeWorkingPeriodFragment(): WorkingPeriodFragment

}