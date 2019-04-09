package com.evgvin.loan.ui.intro.info

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.evgvin.loan.BR
import com.evgvin.loan.R
import com.evgvin.loan.databinding.FragmentInfoBinding
import com.evgvin.loan.ui.base.BaseFragment
import com.evgvin.loan.ui.intro.info.InfoFragmentArgs.fromBundle

class InfoFragment : BaseFragment<FragmentInfoBinding, InfoViewModel>() {

    override lateinit var viewModel: InfoViewModel

    override fun getLayoutId() = R.layout.fragment_info

    override fun getBindingVariable() = BR.viewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(InfoViewModel::class.java)
        arguments?.let {
            val args = fromBundle(it)
            viewModel.apply {
                title.set(args.title)
                description.set(args.description)
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

}