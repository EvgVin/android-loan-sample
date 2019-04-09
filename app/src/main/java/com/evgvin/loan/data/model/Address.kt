package com.evgvin.loan.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("state")
    @Expose
    var state: String? = null,
    @SerializedName("city")
    @Expose
    var city: String? = null,
    @SerializedName("street")
    @Expose
    var street: String? = null
)