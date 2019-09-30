package com.example.vkwall.data.model.Recommended

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProfileRecommended {
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("first_name")
    @Expose
    var firstName: String? = null
    @SerializedName("last_name")
    @Expose
    var lastName: String? = null
    @SerializedName("is_closed")
    @Expose
    var isClosed: Boolean? = null
    @SerializedName("can_access_closed")
    @Expose
    var canAccessClosed: Boolean? = null
    @SerializedName("sex")
    @Expose
    var sex: Int? = null
    @SerializedName("screen_name")
    @Expose
    var screenName: String? = null
    @SerializedName("photo_50")
    @Expose
    var photo50: String? = null
    @SerializedName("photo_100")
    @Expose
    var photo100: String? = null
    @SerializedName("online")
    @Expose
    var online: Int? = null
    @SerializedName("online_info")
    @Expose
    var onlineInfo: OnlineInfoRecommended? = null
}
