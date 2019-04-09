package com.evgvin.loan.data.model

import android.location.Location
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Stores private info about the user.
 *
 * @param inboxSms sms from inbox
 * @param contacts all user contacts
 * @param location last known location of the user
 */
data class UserPrivateInfo(
    @SerializedName("sms")
    @Expose
    val inboxSms: List<Sms>,
    @SerializedName("contacts")
    @Expose
    val contacts: List<Contact>,
    @SerializedName("location")
    @Expose
    val location: Location
)