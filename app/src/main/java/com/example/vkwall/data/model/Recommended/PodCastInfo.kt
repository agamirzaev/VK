package com.example.vkwall.data.model.Recommended

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PodCastInfo {
    @SerializedName("cover")
    @Expose
    var cover: Cover? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("plays")
    @Expose
    var plays: Int? = null
    @SerializedName("position")
    @Expose
    var position: Int? = null
}
