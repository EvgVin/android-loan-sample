package com.evgvin.loan.ui.selfie

import android.Manifest
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.priyankvasa.android.cameraviewex.CameraView
import com.tbruyelle.rxpermissions2.RxPermissions
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentSelfieBinding
import com.evgvin.loan.ui.base.BaseFragment
import com.evgvin.loan.ui.common.autoCleared
import com.evgvin.loan.util.showSnackbar
import java.io.File

class SelfieFragment : BaseFragment<FragmentSelfieBinding, SelfieViewModel>(), SelfieNavigator {

    private val requiredPermissions = arrayOf(Manifest.permission.CAMERA)

    override lateinit var viewModel: SelfieViewModel

    private var cameraView: CameraView by autoCleared()

    override fun getLayoutId() = R.layout.fragment_selfie

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SelfieViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        setupCameraView()
        subscribeToLiveData()
    }

    private fun setupCameraView() {
        cameraView = viewDataBinding.cameraView.apply {
            addPictureTakenListener { viewModel.savePhoto(it) }
        }
    }

    private fun subscribeToLiveData() {
        viewModel.apply {
            makePhotoEvent.observe(this@SelfieFragment, Observer<Void> {
                makePhoto()
            })
            snackbarMessage.observe(this@SelfieFragment, Observer<String> {
                viewDataBinding.root.showSnackbar(it, Snackbar.LENGTH_SHORT)
            })
            savedAvatarFile.observe(this@SelfieFragment, Observer<File> {
                it?.let { showAvatarPreview() }
            })
        }
    }

    @SuppressWarnings("MissingPermission")
    override fun makePhoto() {
        requestRequiredPermissions { cameraView.capture() }
    }

    override fun showAvatarPreview() {
        findNavController().navigate(SelfieFragmentDirections.showSelfiePreview())
    }

    @SuppressWarnings("MissingPermission")
    override fun onResume() {
        super.onResume()
        requestRequiredPermissions() { cameraView.start() }
    }

    private fun requestRequiredPermissions(action: () -> Unit) {
        uiCompositeDisposable.add(
            RxPermissions(this)
                .request(*requiredPermissions)
                .subscribe {
                    if (it) {
                        action()
                    } else {
                        viewDataBinding.root.showSnackbar(
                            getString(R.string.allow_permissions_error),
                            Snackbar.LENGTH_SHORT
                        )
                    }
                })
    }

    override fun onPause() {
        cameraView.stop()
        super.onPause()
    }

    override fun onDestroyView() {
        cameraView.destroy()
        super.onDestroyView()
    }

}