package com.evgvin.loan.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Contact(
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("phone")
    @Expose
    var phone: String
)