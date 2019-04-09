package com.evgvin.loan.ui.welcome

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentWelcomeBinding
import com.evgvin.loan.ui.base.BaseFragment
import com.evgvin.loan.util.setupActionBar

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding, WelcomeViewModel>(),
    WelcomeNavigator {

    override lateinit var viewModel: WelcomeViewModel

    override fun getLayoutId() = R.layout.fragment_welcome

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(WelcomeViewModel::class.java)
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
            verifyIdentityEvent.observe(this@WelcomeFragment, Observer<Void> {
                verifyIdentity()
            })
            skipEvent.observe(this@WelcomeFragment, Observer<Void> {
                skip()
            })
        }
    }

    override fun verifyIdentity() {
        findNavController().navigate(WelcomeFragmentDirections.showVerification())
    }

    override fun skip() {
        findNavController().navigate(WelcomeFragmentDirections.showHome())
    }

}