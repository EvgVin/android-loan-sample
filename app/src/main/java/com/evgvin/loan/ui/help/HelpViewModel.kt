package com.evgvin.loan.ui.help

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import com.evgvin.loan.data.repository.HelpRepository
import com.evgvin.loan.data.model.Help
import com.evgvin.loan.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HelpViewModel @Inject constructor(private val helpRepository: HelpRepository) : BaseViewModel() {

    val help = MutableLiveData<List<Help>>()
    val dataLoading = ObservableBoolean(false)

    init {
        loadHelp()
    }

    private fun loadHelp() {
        dataLoading.set(true)
        compositeDisposable.add(helpRepository.loadHelp()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally { dataLoading.set(false) }
            .subscribe {
                help.value = it
            })
    }

}