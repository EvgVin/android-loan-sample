package com.evgvin.loan.data.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.evgvin.loan.R
import com.evgvin.loan.data.model.Help
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HelpRepository @Inject constructor(private val context: Context) {

    /**
     * Loads a list of frequently asked questions.
     */
    fun loadHelp(): Observable<List<Help>> {
        return Observable.create { emitter ->
            context.resources.openRawResource(R.raw.help).bufferedReader().use {
                val text = it.readText()
                val type = TypeToken.getParameterized(List::class.java, Help::class.java).type
                val items = Gson().fromJson<List<Help>>(text, type)
                emitter.onNext(items)
            }
            emitter.onComplete()
        }
    }

}