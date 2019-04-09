package com.evgvin.loan.ui.identity_verified

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentIdentityVerifiedBinding
import com.evgvin.loan.ui.base.BaseFragment
import com.evgvin.loan.util.setupActionBar

class IdentityVerifiedFragment : BaseFragment<FragmentIdentityVerifiedBinding, IdentityVerifiedViewModel>(),
    IdentityVerifiedNavigator {

    override lateinit var viewModel: IdentityVerifiedViewModel

    override fun getLayoutId() = R.layout.fragment_identity_verified

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(IdentityVerifiedViewModel::class.java)
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
            okEvent.observe(this@IdentityVerifiedFragment, Observer<Void> {
                ok()
            })
        }
    }

    override fun ok() {
        findNavController().navigate(IdentityVerifiedFragmentDirections.showApplicationIntro())
    }

}