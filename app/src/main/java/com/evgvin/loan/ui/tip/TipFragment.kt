package com.evgvin.loan.ui.tip

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.BR
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentTipBinding
import com.evgvin.loan.ui.base.BaseFragment
import com.evgvin.loan.util.setupActionBar

class TipFragment : BaseFragment<FragmentTipBinding, TipViewModel>() {

    override lateinit var viewModel: TipViewModel

    override fun getLayoutId() = R.layout.fragment_tip

    override fun getBindingVariable() = BR.viewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TipViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
    }

    private fun setupToolbar() {
        viewDataBinding.apply {
            setupActionBar(toolbar) {
                setDisplayHomeAsUpEnabled(true)
                setDisplayShowHomeEnabled(true)
                setDisplayShowTitleEnabled(false)
            }
            tvToolbarTitle.text = getString(R.string.tip_title)
        }
    }

}