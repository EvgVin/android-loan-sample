package com.evgvin.loan.ui.application_steps

import android.content.Context
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import com.evgvin.loan.R
import com.evgvin.loan.data.model.Question
import com.evgvin.loan.data.repository.ApplicationRepository
import com.evgvin.loan.ui.common.SingleLiveEvent
import com.evgvin.loan.ui.steps_container.StepsContainerViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ApplicationStepsViewModel @Inject constructor(
    private var context: Context,
    private var applicationRepository: ApplicationRepository
) : StepsContainerViewModel() {

    val questions: MutableLiveData<List<Question>> by lazy {
        MutableLiveData<List<Question>>().apply { this.value = applicationRepository.itemsList }
    }

    val dataLoading = ObservableBoolean(false)
    val snackbarMessage = SingleLiveEvent<String>()

    init {
        loadQuestions()
    }

    private fun loadQuestions() {
        dataLoading.set(true)
        compositeDisposable.add(applicationRepository.loadQuestionsList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally { dataLoading.set(false) }
            .subscribe({
                questions.value = it
            }, {
                snackbarMessage.value = context.getString(R.string.languages_error)
            }))
    }

}