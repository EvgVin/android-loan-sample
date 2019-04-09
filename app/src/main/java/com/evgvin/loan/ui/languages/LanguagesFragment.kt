package com.evgvin.loan.ui.languages

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.evgvin.loan.BR
import com.evgvin.loan.R
import com.evgvin.loan.data.model.Language
import com.evgvin.loan.databinding.FragmentLanguagesBinding
import com.evgvin.loan.databinding.ItemLanguageBinding
import com.evgvin.loan.ui.base.BaseFragment
import com.evgvin.loan.ui.base.BaseRecyclerAdapter
import com.evgvin.loan.ui.common.autoCleared
import com.evgvin.loan.ui.main.MainViewModel
import com.evgvin.loan.util.setupActionBar
import com.evgvin.loan.util.showSnackbar

class LanguagesFragment : BaseFragment<FragmentLanguagesBinding, LanguagesViewModel>(), LanguageItemNavigator {

    lateinit var parentViewModel: MainViewModel

    override lateinit var viewModel: LanguagesViewModel

    var rvAdapter: BaseRecyclerAdapter<Language, ItemLanguageBinding> by autoCleared()

    override fun getLayoutId() = R.layout.fragment_languages

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LanguagesViewModel::class.java)
        parentViewModel = ViewModelProviders.of(baseActivity, viewModelFactory).get(MainViewModel::class.java)
        super.onViewCreated(view, savedInstanceState)
        setupActionBar(viewDataBinding.toolbar) {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        setupLanguagesList()
        subscribeToLiveData()
    }

    private fun setupLanguagesList() {
        rvAdapter = BaseRecyclerAdapter(R.layout.item_language, BR.model, this)
        viewDataBinding.rvLanguages.apply {
            layoutManager = LinearLayoutManager(this@LanguagesFragment.context)
            adapter = rvAdapter
        }
    }

    private fun subscribeToLiveData() {
        viewModel.apply {
            languages.observe(this@LanguagesFragment, Observer<List<Language>> {
                it?.let { rvAdapter.refreshList(it) }
            })
            snackbarMessage.observe(this@LanguagesFragment, Observer<String> {
                viewDataBinding.root.showSnackbar(it, Snackbar.LENGTH_SHORT)
            })
        }
    }

    override fun itemClicked(data: Language, position: Int) {
        viewModel.changeLanguage(data)
        parentViewModel.languageChosenEvent.call()
        findNavController().navigateUp()
    }

}