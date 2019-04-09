package com.evgvin.loan.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Sms(
    @SerializedName("address")
    @Expose
    var address: String,
    @SerializedName("message")
    @Expose
    var message: String
)