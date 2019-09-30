package com.example.vkwall.data.model.Search

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProfileSearch {
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("first_name")
    @Expose
    var firstName: String? = null
    @SerializedName("last_name")
    @Expose
    var lastName: String? = null
    @SerializedName("photo_50")
    @Expose
    var photo50: String? = null
    @SerializedName("is_closed")
    @Expose
    var isClosed: Boolean? = null
    @SerializedName("can_access_closed")
    @Expose
    var canAccessClosed: Boolean? = null
}
