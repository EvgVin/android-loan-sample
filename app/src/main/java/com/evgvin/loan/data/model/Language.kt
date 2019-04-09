package com.evgvin.loan.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Immutable language class.
 *
 * @param name  name of the language
 * @param code  locale code of the language
 */
data class Language(
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("code")
    @Expose
    val code: String
)