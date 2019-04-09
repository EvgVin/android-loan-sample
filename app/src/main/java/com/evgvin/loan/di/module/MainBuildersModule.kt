package com.evgvin.loan.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.evgvin.loan.di.FragmentScope
import com.evgvin.loan.ui.allow_permissions.AllowPermissionsFragment
import com.evgvin.loan.ui.allow_permissions.AllowPermissionsFragmentModule
import com.evgvin.loan.ui.application_intro.ApplicationIntroFragment
import com.evgvin.loan.ui.application_intro.ApplicationIntroFragmentModule
import com.evgvin.loan.ui.application_steps.ApplicationStepsFragment
import com.evgvin.loan.ui.application_steps.ApplicationStepsFragmentModule
import com.evgvin.loan.ui.help.HelpFragment
import com.evgvin.loan.ui.help.HelpFragmentModule
import com.evgvin.loan.ui.home.HomeFragment
import com.evgvin.loan.ui.home.HomeFragmentModule
import com.evgvin.loan.ui.identity_verified.IdentityVerifiedFragment
import com.evgvin.loan.ui.identity_verified.IdentityVerifiedFragmentModule
import com.evgvin.loan.ui.intro.IntroFragment
import com.evgvin.loan.ui.intro.IntroFragmentModule
import com.evgvin.loan.ui.languages.LanguagesFragment
import com.evgvin.loan.ui.languages.LanguagesFragmentModule
import com.evgvin.loan.ui.loan_congratulations.LoanCongratulationsFragment
import com.evgvin.loan.ui.loan_congratulations.LoanCongratulationsFragmentModule
import com.evgvin.loan.ui.loan_purpose.LoanPurposeFragment
import com.evgvin.loan.ui.loan_purpose.LoanPurposeFragmentModule
import com.evgvin.loan.ui.loan_purpose_detailed_steps.LoanPurposeDetailedFragmentModule
import com.evgvin.loan.ui.loan_purpose_detailed_steps.LoanPurposeDetailedStepsFragment
import com.evgvin.loan.ui.log_in_steps.LogInStepsFragment
import com.evgvin.loan.ui.log_in_steps.LogInStepsFragmentModule
import com.evgvin.loan.ui.payment_steps.PaymentStepsFragment
import com.evgvin.loan.ui.payment_steps.PaymentStepsFragmentModule
import com.evgvin.loan.ui.registration_steps.RegistrationStepsFragment
import com.evgvin.loan.ui.registration_steps.RegistrationStepsFragmentModule
import com.evgvin.loan.ui.selfie.SelfieFragment
import com.evgvin.loan.ui.selfie.SelfieFragmentModule
import com.evgvin.loan.ui.selfie_preview.SelfiePreviewFragment
import com.evgvin.loan.ui.selfie_preview.SelfiePreviewFragmentModule
import com.evgvin.loan.ui.tip.TipFragment
import com.evgvin.loan.ui.tip.TipFragmentModule
import com.evgvin.loan.ui.verification_steps.VerificationStepsFragment
import com.evgvin.loan.ui.verification_steps.VerificationStepsFragmentModule
import com.evgvin.loan.ui.welcome.WelcomeFragment
import com.evgvin.loan.ui.welcome.WelcomeFragmentModule

@Module
abstract class MainBuildersModule {

    @ContributesAndroidInjector(modules = [IntroFragmentModule::class])
    abstract fun contributeIntroFragment(): IntroFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [RegistrationStepsFragmentModule::class])
    abstract fun contributeRegistrationStepsFragment(): RegistrationStepsFragment

    @ContributesAndroidInjector(modules = [LogInStepsFragmentModule::class])
    abstract fun contributeLogInStepsFragment(): LogInStepsFragment

    @ContributesAndroidInjector(modules = [LanguagesFragmentModule::class])
    abstract fun contributeLanguagesFragment(): LanguagesFragment

    @ContributesAndroidInjector(modules = [AllowPermissionsFragmentModule::class])
    abstract fun contributeAllowPermissionsFragment(): AllowPermissionsFragment

    @ContributesAndroidInjector(modules = [WelcomeFragmentModule::class])
    abstract fun contributeWelcomeFragment(): WelcomeFragment

    @ContributesAndroidInjector(modules = [VerificationStepsFragmentModule::class])
    abstract fun contributeVerificationStepsFragment(): VerificationStepsFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector(modules = [HelpFragmentModule::class])
    abstract fun contributeHelpFragment(): HelpFragment

    @ContributesAndroidInjector(modules = [TipFragmentModule::class])
    abstract fun contributeTipFragment(): TipFragment

    @ContributesAndroidInjector(modules = [ApplicationIntroFragmentModule::class])
    abstract fun contributeApplicationIntroFragment(): ApplicationIntroFragment

    @ContributesAndroidInjector(modules = [SelfieFragmentModule::class])
    abstract fun contributeSelfieFragment(): SelfieFragment

    @ContributesAndroidInjector(modules = [SelfiePreviewFragmentModule::class])
    abstract fun contributeSelfiePreviewFragment(): SelfiePreviewFragment

    @ContributesAndroidInjector(modules = [IdentityVerifiedFragmentModule::class])
    abstract fun contributeIdentityVerifiedFragment(): IdentityVerifiedFragment

    @ContributesAndroidInjector(modules = [LoanPurposeFragmentModule::class])
    abstract fun contributeLoanPurposeFragment(): LoanPurposeFragment

    @ContributesAndroidInjector(modules = [LoanPurposeDetailedFragmentModule::class])
    abstract fun contributeLoanPurposeDetailedFragment(): LoanPurposeDetailedStepsFragment

    @ContributesAndroidInjector(modules = [LoanCongratulationsFragmentModule::class])
    abstract fun contributeLoanCongratulationsFragment(): LoanCongratulationsFragment

    @ContributesAndroidInjector(modules = [PaymentStepsFragmentModule::class])
    abstract fun contributePaymentStepsFragment(): PaymentStepsFragment

    @ContributesAndroidInjector(modules = [ApplicationStepsFragmentModule::class])
    abstract fun contributeApplicationStepsFragment(): ApplicationStepsFragment

}