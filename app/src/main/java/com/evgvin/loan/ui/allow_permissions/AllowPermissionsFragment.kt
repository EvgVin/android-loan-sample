package com.evgvin.loan.ui.allow_permissions

import android.Manifest
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.tbruyelle.rxpermissions2.RxPermissions
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentAllowPermissionsBinding
import com.evgvin.loan.ui.base.BaseFragment
import com.evgvin.loan.util.setupActionBar
import com.evgvin.loan.util.showSnackbar

class AllowPermissionsFragment : BaseFragment<FragmentAllowPermissionsBinding, AllowPermissionsViewModel>(),
    AllowPermissionsNavigator {

    /**
     * All permissions for which the user must agree.
     */
    private val requiredPermissions = arrayOf(
        Manifest.permission.READ_CONTACTS,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.READ_SMS
    )

    override lateinit var viewModel: AllowPermissionsViewModel

    override fun getLayoutId() = R.layout.fragment_allow_permissions

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(AllowPermissionsViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        setupActionBar(viewDataBinding.toolbar) {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setDisplayShowTitleEnabled(false)
        }
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        viewModel.apply {
            allowAccessEvent.observe(this@AllowPermissionsFragment, Observer<Void> {
                allowAccess()
            })
            learnMoreEvent.observe(this@AllowPermissionsFragment, Observer<Void> {
                learnMore()
            })
            userPrivateInfoSavedEvent.observe(this@AllowPermissionsFragment, Observer<Void> {
                userPrivateInfoSaved()
            })
            snackbarMessage.observe(this@AllowPermissionsFragment, Observer<String> {
                viewDataBinding.root.showSnackbar(it, Snackbar.LENGTH_SHORT)
            })
        }
    }

    override fun allowAccess() {
        requestRequiredPermissions()
    }

    private fun requestRequiredPermissions() {
        uiCompositeDisposable.add(RxPermissions(this)
                .request(*requiredPermissions)
                .subscribe {
                    if (it) {
                        viewModel.sendUserInformation()
                    } else {
                        viewDataBinding.root.showSnackbar(
                            getString(R.string.allow_permissions_error),
                            Snackbar.LENGTH_SHORT
                        )
                    }
                })
    }

    override fun userPrivateInfoSaved() {
        findNavController().navigate(AllowPermissionsFragmentDirections.showWelcome())
    }

    override fun learnMore() {

    }

}