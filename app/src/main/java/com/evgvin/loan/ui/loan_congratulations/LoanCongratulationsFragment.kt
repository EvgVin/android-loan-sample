package com.evgvin.loan.ui.loan_congratulations

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentLoanCongratulationsBinding
import com.evgvin.loan.ui.base.BaseFragment
import com.evgvin.loan.util.setupActionBar

class LoanCongratulationsFragment : BaseFragment<FragmentLoanCongratulationsBinding, LoanCongratulationsViewModel>(),
    LoanCongratulationsNavigator {

    override lateinit var viewModel: LoanCongratulationsViewModel

    override fun getLayoutId() = R.layout.fragment_loan_congratulations

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LoanCongratulationsViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.toolbar.apply {
            setupActionBar(this) {
                setDisplayHomeAsUpEnabled(true)
                setDisplayShowHomeEnabled(true)
                setDisplayShowTitleEnabled(false)
            }
            setNavigationIcon(R.drawable.close_icon)
        }
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        viewModel.apply {
            selectAmountEvent.observe(this@LoanCongratulationsFragment, Observer<Void> {
                selectAmount()
            })
            notNowEvent.observe(this@LoanCongratulationsFragment, Observer<Void> {
                notNow()
            })
        }
    }

    override fun selectAmount() {
        findNavController().navigate(LoanCongratulationsFragmentDirections.showPaymentSteps())
    }

    override fun notNow() {

    }

}