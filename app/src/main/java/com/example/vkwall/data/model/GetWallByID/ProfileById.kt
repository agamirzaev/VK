package com.example.vkwall.data.model.GetWallByID

import com.google.gson.annotations.SerializedName

class ProfileById {
    @SerializedName("id")
    var id: Int? = null
    @SerializedName("first_name")
    var firstName: String? = null
    @SerializedName("last_name")
    var lastName: String? = null
    @SerializedName("is_closed")
    var isClosed: Boolean? = null
    @SerializedName("can_access_closed")
    var canAccessClosed: Boolean? = null
    @SerializedName("sex")
    var sex: Int? = null
    @SerializedName("screen_name")
    var screenName: String? = null
    @SerializedName("photo_50")
    var photo50: String? = null
    @SerializedName("photo_100")
    var photo100: String? = null
    @SerializedName("photo_max_orig")
    var photo_max_orig: String? = null
    @SerializedName("online")
    var online: Int? = null
}
