package com.evgvin.loan.ui.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentHomeBinding
import com.evgvin.loan.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    private val childNavController: NavController by lazy {
        Navigation.findNavController(viewDataBinding.root.findViewById(R.id.homeContainer))
    }

    override lateinit var viewModel: HomeViewModel

    override fun getLayoutId() = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        NavigationUI.setupWithNavController(viewDataBinding.bottomNavigation, childNavController)
    }

}