package com.evgvin.loan.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * This model class is used to store user answer.
 *
 * @param questionId    id of the question
 * @param value         value of the user answer
 */
data class Answer(
    @SerializedName("questionId")
    @Expose
    val questionId: Int,
    @SerializedName("value")
    @Expose
    val value: Any
)