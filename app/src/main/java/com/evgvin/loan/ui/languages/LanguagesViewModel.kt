package com.evgvin.loan.ui.languages

import android.content.Context
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import com.evgvin.loan.Constants
import com.evgvin.loan.R
import com.evgvin.loan.data.model.Language
import com.evgvin.loan.data.repository.LanguagesRepository
import com.evgvin.loan.data.repository.UserRepository
import com.evgvin.loan.ui.base.BaseViewModel
import com.evgvin.loan.ui.common.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LanguagesViewModel @Inject constructor(
    private val context: Context,
    private val userRepository: UserRepository,
    private val languagesRepository: LanguagesRepository
) : BaseViewModel() {

    val languages = MutableLiveData<List<Language>>()
    val dataLoading = ObservableBoolean(false)
    val snackbarMessage = SingleLiveEvent<String>()

    init {
        loadLanguages()
    }

    /**
     * Changes default app language.
     */
    fun changeLanguage(language: Language?) {
        userRepository.changeLanguageCode(language?.code ?: Constants.BASE_LOCALE)
    }

    /**
     * Loads all available languages supported by the application.
     */
    private fun loadLanguages() {
        dataLoading.set(true)
        compositeDisposable.add(languagesRepository.loadLanguages()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally { dataLoading.set(false) }
            .subscribe({
                languages.value = it
            }, {
                snackbarMessage.value = context.getString(R.string.languages_error)
            }))
    }

}