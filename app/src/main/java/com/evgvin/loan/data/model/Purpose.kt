package com.evgvin.loan.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Purpose(
    @SerializedName("id")
    @Expose
    override val id: Int,
    @SerializedName("name")
    @Expose
    val name: String
) : CachedItem