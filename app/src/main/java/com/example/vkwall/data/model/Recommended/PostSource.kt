package com.example.vkwall.data.model.Recommended

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PostSource {
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("platform")
    @Expose
    var platform: String? = null
}
