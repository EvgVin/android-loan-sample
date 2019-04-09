package com.evgvin.loan.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Help(
    @SerializedName("question")
    @Expose
    val question: String,
    @SerializedName("answer")
    @Expose
    val answer: String
)