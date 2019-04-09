package com.evgvin.loan.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Occupation(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("name")
    @Expose
    val name: String
) {

    override fun toString() = name

}