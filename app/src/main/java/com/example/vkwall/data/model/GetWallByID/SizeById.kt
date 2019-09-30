package com.example.vkwall.data.model.GetWallByID

import com.google.gson.annotations.SerializedName

class SizeById {
    @SerializedName("type")
    var type: String? = null
    @SerializedName("url")
    var url: String? = null
    @SerializedName("width")
    var width: Int? = null
    @SerializedName("height")
    var height: Int? = null
}
