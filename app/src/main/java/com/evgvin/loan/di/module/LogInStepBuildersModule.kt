package com.evgvin.loan.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.evgvin.loan.ui.log_in_steps.confirmation.ConfirmationFragment
import com.evgvin.loan.ui.log_in_steps.phone.PhoneFragment
import com.evgvin.loan.ui.log_in_steps.pin.PinFragment
import com.evgvin.loan.ui.registration_steps.phone_confirmation.PhoneConfirmationFragmentModule
import com.evgvin.loan.ui.registration_steps.phone_number.PhoneNumberFragmentModule
import com.evgvin.loan.ui.registration_steps.pin_creation.PinCreationFragmentModule

@Module
abstract class LogInStepBuildersModule {

    @ContributesAndroidInjector(modules = [PhoneNumberFragmentModule::class])
    abstract fun contributePhoneFragment(): PhoneFragment

    @ContributesAndroidInjector(modules = [PhoneConfirmationFragmentModule::class])
    abstract fun contributeConfirmationFragment(): ConfirmationFragment

    @ContributesAndroidInjector(modules = [PinCreationFragmentModule::class])
    abstract fun contributePinFragment(): PinFragment

}