package com.evgvin.loan.ui.selfie_preview

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentSelfiePreviewBinding
import com.evgvin.loan.ui.base.BaseFragment

class SelfiePreviewFragment : BaseFragment<FragmentSelfiePreviewBinding, SelfiePreviewViewModel>(), SelfiePreviewNavigator {

    override lateinit var viewModel: SelfiePreviewViewModel

    override fun getLayoutId() = R.layout.fragment_selfie_preview

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SelfiePreviewViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        viewModel.apply {
            retakeEvent.observe(this@SelfiePreviewFragment, Observer<Void> {
                retake()
            })
            usePhotoEvent.observe(this@SelfiePreviewFragment, Observer<Void> {
                usePhoto()
            })
        }
    }

    override fun retake() {
        findNavController().navigateUp()
    }

    override fun usePhoto() {
        findNavController().navigate(SelfiePreviewFragmentDirections.showIdentityVerified())
    }

}