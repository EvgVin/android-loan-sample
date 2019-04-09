package com.evgvin.loan.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Immutable class is used to transfer chat messages.
 *
 * @param id        id of the message
 * @param message   text of the message
 * @param isSelf    shows the owner of the message
 */
data class Message(
    @SerializedName("id")
    @Expose
    val id: String,
    @SerializedName("message")
    @Expose
    val message: String,
    @SerializedName("isSelf")
    @Expose
    val isSelf: Boolean
)