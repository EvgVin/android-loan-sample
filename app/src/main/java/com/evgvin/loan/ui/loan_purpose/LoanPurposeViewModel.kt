package com.evgvin.loan.ui.loan_purpose

import android.content.Context
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import com.evgvin.loan.R
import com.evgvin.loan.data.model.Purpose
import com.evgvin.loan.data.repository.LoanPurposeRepository
import com.evgvin.loan.ui.base.BaseViewModel
import com.evgvin.loan.ui.common.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoanPurposeViewModel @Inject constructor(
    private val context: Context,
    private val loanPurposeRepository: LoanPurposeRepository
) : BaseViewModel() {

    val purposes: MutableLiveData<List<Purpose>> by lazy {
        MutableLiveData<List<Purpose>>().apply { this.value = loanPurposeRepository.itemsList }
    }

    val dataLoading = ObservableBoolean(false)
    val snackbarMessage = SingleLiveEvent<String>()

    init {
        loadLoanPurposes()
    }

    private fun loadLoanPurposes() {
        dataLoading.set(true)
        compositeDisposable.add(loanPurposeRepository.loadLoanPurposesList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally { dataLoading.set(false) }
            .subscribe({
                purposes.value = it
            }, {
                snackbarMessage.value = context.getString(R.string.languages_error)
            }))
    }

}