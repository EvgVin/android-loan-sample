package com.evgvin.loan.ui.loan_purpose

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.evgvin.loan.BR
import com.evgvin.loan.R
import com.evgvin.loan.data.model.Purpose
import com.evgvin.loan.databinding.FragmentLoanPurposeBinding
import com.evgvin.loan.databinding.ItemPurposeBinding
import com.evgvin.loan.ui.base.BaseFragment
import com.evgvin.loan.ui.base.BaseRecyclerAdapter
import com.evgvin.loan.ui.common.autoCleared
import com.evgvin.loan.util.setupActionBar
import com.evgvin.loan.util.showSnackbar

class LoanPurposeFragment : BaseFragment<FragmentLoanPurposeBinding, LoanPurposeViewModel>(), LoanPurposeItemNavigator {

    override lateinit var viewModel: LoanPurposeViewModel

    var rvAdapter: BaseRecyclerAdapter<Purpose, ItemPurposeBinding> by autoCleared()

    override fun getLayoutId() = R.layout.fragment_loan_purpose

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LoanPurposeViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        setupActionBar(viewDataBinding.toolbar) {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        setupLoanPurposeList()
        subscribeToLiveData()
    }

    private fun setupLoanPurposeList() {
        rvAdapter = BaseRecyclerAdapter(R.layout.item_purpose, BR.model, this)
        viewDataBinding.rvLoanPurpose.apply {
            layoutManager = LinearLayoutManager(this@LoanPurposeFragment.context)
            adapter = rvAdapter
        }
    }

    private fun subscribeToLiveData() {
        viewModel.apply {
            purposes.observe(this@LoanPurposeFragment, Observer<List<Purpose>> {
                it?.let { rvAdapter.refreshList(it) }
            })
            snackbarMessage.observe(this@LoanPurposeFragment, Observer<String> {
                viewDataBinding.root.showSnackbar(it, Snackbar.LENGTH_SHORT)
            })
        }
    }

    override fun itemClicked(data: Purpose, position: Int) {
        findNavController().navigate(LoanPurposeFragmentDirections.showLoanPurposeDetailedSteps(data.id))
    }

}