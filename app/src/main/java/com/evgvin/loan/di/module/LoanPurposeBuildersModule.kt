package com.evgvin.loan.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.evgvin.loan.ui.loan_purpose_detailed_steps.outstanding_loans.OutstandingLoansFragment
import com.evgvin.loan.ui.loan_purpose_detailed_steps.outstanding_loans.OutstandingLoansFragmentModule
import com.evgvin.loan.ui.loan_purpose_detailed_steps.purpose_description.PurposeDescriptionFragment
import com.evgvin.loan.ui.loan_purpose_detailed_steps.purpose_description.PurposeDescriptionFragmentModule

@Module
abstract class LoanPurposeBuildersModule {

    @ContributesAndroidInjector(modules = [PurposeDescriptionFragmentModule::class])
    abstract fun contributePurposeDescriptionFragment(): PurposeDescriptionFragment

    @ContributesAndroidInjector(modules = [OutstandingLoansFragmentModule::class])
    abstract fun contributeOutstandingLoansFragment(): OutstandingLoansFragment

}