package com.evgvin.loan.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.evgvin.loan.ui.registration_steps.choose_language.ChooseLanguageFragment
import com.evgvin.loan.ui.registration_steps.choose_language.ChooseLanguageFragmentModule
import com.evgvin.loan.ui.registration_steps.education_level.EducationLevelFragment
import com.evgvin.loan.ui.registration_steps.education_level.EducationLevelFragmentModule
import com.evgvin.loan.ui.registration_steps.email_entering.EmailEnteringFragment
import com.evgvin.loan.ui.registration_steps.email_entering.EmailEnteringFragmentModule
import com.evgvin.loan.ui.registration_steps.employment.EmploymentFragment
import com.evgvin.loan.ui.registration_steps.employment.EmploymentFragmentModule
import com.evgvin.loan.ui.registration_steps.first_name.FirstNameFragment
import com.evgvin.loan.ui.registration_steps.first_name.FirstNameFragmentModule
import com.evgvin.loan.ui.registration_steps.last_name.LastNameFragment
import com.evgvin.loan.ui.registration_steps.last_name.LastNameFragmentModule
import com.evgvin.loan.ui.registration_steps.phone_confirmation.PhoneConfirmationFragment
import com.evgvin.loan.ui.registration_steps.phone_confirmation.PhoneConfirmationFragmentModule
import com.evgvin.loan.ui.registration_steps.phone_number.PhoneNumberFragment
import com.evgvin.loan.ui.registration_steps.phone_number.PhoneNumberFragmentModule
import com.evgvin.loan.ui.registration_steps.pin_confirmation.PinConfirmationFragment
import com.evgvin.loan.ui.registration_steps.pin_confirmation.PinConfirmationFragmentModule
import com.evgvin.loan.ui.registration_steps.pin_creation.PinCreationFragment
import com.evgvin.loan.ui.registration_steps.pin_creation.PinCreationFragmentModule

@Module
abstract class RegistrationStepBuildersModule {

    @ContributesAndroidInjector(modules = [ChooseLanguageFragmentModule::class])
    abstract fun contributeChooseLanguageFragment(): ChooseLanguageFragment

    @ContributesAndroidInjector(modules = [PhoneNumberFragmentModule::class])
    abstract fun contributePhoneNumberFragment(): PhoneNumberFragment

    @ContributesAndroidInjector(modules = [PhoneConfirmationFragmentModule::class])
    abstract fun contributePhoneConfirmationFragment(): PhoneConfirmationFragment

    @ContributesAndroidInjector(modules = [PinCreationFragmentModule::class])
    abstract fun contributePinCreationFragment(): PinCreationFragment

    @ContributesAndroidInjector(modules = [PinConfirmationFragmentModule::class])
    abstract fun contributePinConfirmationFragment(): PinConfirmationFragment

    @ContributesAndroidInjector(modules = [EmailEnteringFragmentModule::class])
    abstract fun contributeEmailEnteringFragment(): EmailEnteringFragment

    @ContributesAndroidInjector(modules = [FirstNameFragmentModule::class])
    abstract fun contributeFirstNameFragment(): FirstNameFragment

    @ContributesAndroidInjector(modules = [LastNameFragmentModule::class])
    abstract fun contributeLastNameFragment(): LastNameFragment

    @ContributesAndroidInjector(modules = [EducationLevelFragmentModule::class])
    abstract fun contributeEducationLevelFragment(): EducationLevelFragment

    @ContributesAndroidInjector(modules = [EmploymentFragmentModule::class])
    abstract fun contributeEmploymentFragment(): EmploymentFragment

}