package com.evgvin.loan.ui.intro

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentIntroBinding
import com.evgvin.loan.ui.base.BaseFragment
import com.evgvin.loan.ui.common.ViewPagerAdapter
import com.evgvin.loan.ui.intro.info.InfoFragment
import com.evgvin.loan.ui.intro.info.InfoFragmentArgs
import com.evgvin.loan.util.initArguments

class IntroFragment : BaseFragment<FragmentIntroBinding, IntroViewModel>(), IntroNavigator {

    override lateinit var viewModel: IntroViewModel

    override fun getLayoutId() = R.layout.fragment_intro

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(IntroViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
        subscribeToLiveData()
    }

    private fun setupViewPager() {
        val pagerAdapter = ViewPagerAdapter(childFragmentManager)
        pagerAdapter.apply {
            val args = InfoFragmentArgs.Builder(R.string.info_title, R.string.info_description).build().toBundle()
            addFragment(InfoFragment().initArguments(args), "")
            addFragment(InfoFragment().initArguments(args), "")
            addFragment(InfoFragment().initArguments(args), "")
        }
        viewDataBinding.apply {
            viewPager.adapter = pagerAdapter
            dotsIndicator.setViewPager(viewPager)
        }
    }

    private fun subscribeToLiveData() {
        viewModel.apply {
            openRegistrationEvent.observe(this@IntroFragment, Observer<Void> {
                createAccount()
            })
            openLogInEvent.observe(this@IntroFragment, Observer<Void> {
                logIn()
            })
        }
    }

    override fun createAccount() {
        findNavController().navigate(IntroFragmentDirections.showRegistration())
    }

    override fun logIn() {
        findNavController().navigate(IntroFragmentDirections.showLogIn())
    }

}