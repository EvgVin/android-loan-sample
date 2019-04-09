package com.evgvin.loan.ui.home.feed

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentFeedBinding
import com.evgvin.loan.ui.base.BaseFragment
import com.evgvin.loan.ui.home.HomeFragment
import com.evgvin.loan.ui.home.HomeFragmentDirections
import com.evgvin.loan.util.setupActionBar
import javax.inject.Inject


class FeedFragment : BaseFragment<FragmentFeedBinding, FeedViewModel>(), FeedNavigator {

    @Inject
    lateinit var parentFragment: HomeFragment

    override lateinit var viewModel: FeedViewModel

    override fun getLayoutId() = R.layout.fragment_feed

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(FeedViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        subscribeToLiveData()
    }

    private fun setupToolbar() {
        viewDataBinding.apply {
            setupActionBar(toolbar, false) {
                setDisplayShowTitleEnabled(false)
            }
            tvToolbarTitle.text = getString(com.evgvin.loan.R.string.feed_title)
        }
    }

    private fun subscribeToLiveData() {
        viewModel.apply {
            applyEvent.observe(this@FeedFragment, Observer<Void> {
                applyALoan()
            })
            referEvent.observe(this@FeedFragment, Observer<Void> {
                referAFriend()
            })
            increaseScoreEvent.observe(this@FeedFragment, Observer<Void> {
                increaseCreditScore()
            })
        }
    }

    override fun applyALoan() {
        parentFragment.findNavController().navigate(HomeFragmentDirections.showApplicationIntro())
    }

    override fun referAFriend() {
    }

    override fun increaseCreditScore() {
        parentFragment.findNavController().navigate(HomeFragmentDirections.showTip())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        NavigationUI.onNavDestinationSelected(item, parentFragment.findNavController())
        return super.onOptionsItemSelected(item)
    }

}