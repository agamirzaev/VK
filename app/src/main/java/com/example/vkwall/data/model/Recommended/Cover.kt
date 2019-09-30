package com.example.vkwall.data.model.Recommended

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Cover {
    @SerializedName("sizes")
    @Expose
    var sizes: List<Size_>? = null
}
