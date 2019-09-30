package com.example.vkwall.data.model.ProfileWall.Comments

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class OnlineInfo {
    @SerializedName("visible")
    @Expose
    var visible: Boolean? = null
    @SerializedName("is_online")
    @Expose
    var isOnline: Boolean? = null
}
