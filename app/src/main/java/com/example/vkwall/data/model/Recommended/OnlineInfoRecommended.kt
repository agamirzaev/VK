package com.example.vkwall.data.model.Recommended

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class OnlineInfoRecommended {
    @SerializedName("visible")
    @Expose
    var visible: Boolean? = null
    @SerializedName("last_seen")
    @Expose
    var lastSeen: Int? = null
    @SerializedName("app_id")
    @Expose
    var appId: Int? = null
    @SerializedName("is_mobile")
    @Expose
    var isMobile: Boolean? = null
}
