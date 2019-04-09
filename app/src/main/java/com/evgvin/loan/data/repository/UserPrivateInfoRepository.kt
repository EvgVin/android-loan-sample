package com.evgvin.loan.data.repository

import com.evgvin.loan.data.model.UserPrivateInfo
import com.evgvin.loan.data.remote.LoanApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPrivateInfoRepository @Inject constructor(private val loanApi: LoanApi) {

    fun sendUserPrivateInfo(userPrivateInfo: UserPrivateInfo) = loanApi.setUserPrivateInfo(userPrivateInfo)

}