package com.evgvin.loan.data.repository

import com.evgvin.loan.data.model.Language
import com.evgvin.loan.data.remote.LoanApi
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LanguagesRepository @Inject constructor(private val loanApi: LoanApi) {

    /**
     * Loads a list of languages the user can choose.
     */
    fun loadLanguages(): Observable<List<Language>> {
        return loanApi.getLanguages()
    }

}