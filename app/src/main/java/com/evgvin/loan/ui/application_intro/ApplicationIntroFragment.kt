package com.evgvin.loan.ui.application_intro

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentApplicationIntroBinding
import com.evgvin.loan.ui.base.BaseFragment
import com.evgvin.loan.util.setupActionBar

class ApplicationIntroFragment : BaseFragment<FragmentApplicationIntroBinding, ApplicationIntroViewModel>(),
    ApplicationIntroNavigator {

    override lateinit var viewModel: ApplicationIntroViewModel

    override fun getLayoutId() = R.layout.fragment_application_intro

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ApplicationIntroViewModel::class.java)
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
            startApplicationEvent.observe(this@ApplicationIntroFragment, Observer<Void> {
                startApplication()
            })
        }
    }

    override fun startApplication() {
        findNavController().navigate(ApplicationIntroFragmentDirections.showApplicationSteps())
    }

}