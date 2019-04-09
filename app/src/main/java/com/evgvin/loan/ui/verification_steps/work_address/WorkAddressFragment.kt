package com.evgvin.loan.ui.verification_steps.work_address

import android.os.Bundle
import android.view.View
import com.evgvin.loan.R
import com.evgvin.loan.ui.verification_steps.home_address.HomeAddressFragment

class WorkAddressFragment : HomeAddressFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.tvTitle.text = getString(R.string.work_address_title)
    }

    override fun nextStep() {
        parentViewModel.showNextStepEvent.value = WorkAddressFragmentDirections.showWorkingPeriod()
    }

}