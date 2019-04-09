package com.evgvin.loan.ui.help

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.evgvin.loan.R
import com.evgvin.loan.data.model.Help
import com.evgvin.loan.databinding.FragmentHelpBinding
import com.evgvin.loan.ui.base.BaseFragment
import com.evgvin.loan.ui.common.autoCleared
import com.evgvin.loan.util.setupActionBar

class HelpFragment : BaseFragment<FragmentHelpBinding, HelpViewModel>() {

    override lateinit var viewModel: HelpViewModel

    var rvAdapter: HelpAdapter by autoCleared()

    override fun getLayoutId() = R.layout.fragment_help

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HelpViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupHelpList()
        subscribeToLiveData()
    }

    private fun setupToolbar() {
        viewDataBinding.apply {
            setupActionBar(toolbar) {
                setDisplayHomeAsUpEnabled(true)
                setDisplayShowHomeEnabled(true)
                setDisplayShowTitleEnabled(false)
            }
            tvToolbarTitle.text = getString(R.string.help_title)
        }
    }

    private fun setupHelpList() {
        rvAdapter = HelpAdapter()
        viewDataBinding.rvHelp.apply {
            layoutManager = LinearLayoutManager(this@HelpFragment.context)
            adapter = rvAdapter
        }
    }

    private fun subscribeToLiveData() {
        viewModel.apply {
            help.observe(this@HelpFragment, Observer<List<Help>> {
                it?.let { rvAdapter.refreshList(it) }
            })
        }
    }

}