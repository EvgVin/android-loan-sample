package com.evgvin.loan.data.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.evgvin.loan.R
import com.evgvin.loan.data.model.Answer
import com.evgvin.loan.data.model.Question
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApplicationRepository @Inject constructor(private val context: Context) : CachedItemsRepository<Question>() {

    /**
     * Stores answers to all questions of the user.
     */
    private val answers = HashMap<Int, Answer>()

    fun getAnswer(questionId: Int) = answers[questionId]

    fun setAnswer(answer: Answer) {
        answers[answer.questionId] = answer
    }

    /**
     * Loads all questions that the user must answer.
     */
    fun loadQuestionsList(): Observable<List<Question>> {
        return Observable.create { emitter ->
            context.resources.openRawResource(R.raw.questions).bufferedReader().use {
                val text = it.readText()
                val type = TypeToken.getParameterized(List::class.java, Question::class.java).type
                val items = Gson().fromJson<List<Question>>(text, type)
                itemsList = items
                emitter.onNext(items)
            }
            emitter.onComplete()
        }
    }

}