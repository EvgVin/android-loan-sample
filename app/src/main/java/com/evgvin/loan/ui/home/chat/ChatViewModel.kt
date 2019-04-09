package com.evgvin.loan.ui.home.chat

import android.content.Context
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import com.evgvin.loan.R
import com.evgvin.loan.data.model.Message
import com.evgvin.loan.ui.base.BaseViewModel
import com.evgvin.loan.ui.common.SingleLiveEvent
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ChatViewModel @Inject constructor(
    private val context: Context
) : BaseViewModel() {

    val chatHistory = MutableLiveData<List<Message>>()
    val dataLoading = ObservableBoolean(false)
    val snackbarMessage = SingleLiveEvent<String>()

    init {
        loadChatHistory()
    }

    /**
     * Loads chat history between user and support operator.
     */
    private fun loadChatHistory() {
        dataLoading.set(true)
        compositeDisposable.add(Observable.just(testChatHistory())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally { dataLoading.set(false) }
            .subscribe({
                chatHistory.value = it
            }, {
                snackbarMessage.value = context.getString(R.string.languages_error)
            }))
    }

    /**
     * Used for tests only.
     */
    private fun testChatHistory(): List<Message> {
        return arrayListOf(
            Message("0", "Hello!", false),
            Message("1", "My name is Bob", false),
            Message("2", "Hello!", true),
            Message("3", "What can i help you?", false),
            Message("4", "Replenish my account, please", true),
            Message("5", "I am so busy and can't do this", true)
        )
    }

}