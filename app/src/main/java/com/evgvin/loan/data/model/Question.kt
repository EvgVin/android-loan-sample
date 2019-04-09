package com.evgvin.loan.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Immutable class is used to show all questions of the application.
 *
 * @param id          id of the question
 * @param title       title of the message
 * @param description description of the message
 * @param values      list of values that the user can choose
 * @param type        of the question
 */
data class Question(
    @SerializedName("id")
    @Expose
    override val id: Int,
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("description")
    @Expose
    val description: String,
    @SerializedName("values")
    @Expose
    val values: List<String>,
    @SerializedName("type")
    @Expose
    val type: Int
) : CachedItem