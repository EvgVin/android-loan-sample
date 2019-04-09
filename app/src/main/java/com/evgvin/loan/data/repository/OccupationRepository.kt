package com.evgvin.loan.data.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.evgvin.loan.R
import com.evgvin.loan.data.model.Occupation
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OccupationRepository @Inject constructor(private val context: Context) {

    fun loadOccupationsList(): Observable<List<Occupation>> {
        return Observable.create { emitter ->
            context.resources.openRawResource(R.raw.occupations).bufferedReader().use {
                val text = it.readText()
                val type = TypeToken.getParameterized(List::class.java, Occupation::class.java).type
                val items = Gson().fromJson<List<Occupation>>(text, type)
                emitter.onNext(items)
            }
            emitter.onComplete()
        }
    }

}