package com.evgvin.loan.data.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.evgvin.loan.R
import com.evgvin.loan.data.model.Purpose
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoanPurposeRepository @Inject constructor(private val context: Context) : CachedItemsRepository<Purpose>() {

    fun loadLoanPurposesList(): Observable<List<Purpose>> {
        return Observable.create { emitter ->
            context.resources.openRawResource(R.raw.purposes).bufferedReader().use {
                val text = it.readText()
                val type = TypeToken.getParameterized(List::class.java, Purpose::class.java).type
                val items = Gson().fromJson<List<Purpose>>(text, type)
                itemsList = items
                emitter.onNext(items)
            }
            emitter.onComplete()
        }
    }

}