package com.evgvin.loan.data.remote

import com.evgvin.loan.data.model.Language
import com.evgvin.loan.data.model.UserPrivateInfo
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LoanApi {

    @GET("getlang")
    fun getLanguages(): Observable<List<Language>>

    @POST("setprivateinfo")
    fun setUserPrivateInfo(@Body userPrivateInfo: UserPrivateInfo): Observable<Response<ResponseBody>>

}