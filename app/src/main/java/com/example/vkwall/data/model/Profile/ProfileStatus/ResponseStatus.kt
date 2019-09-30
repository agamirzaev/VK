package com.example.vkwall.data.model.Profile.ProfileStatus

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseStatus {
    @SerializedName("text")
    @Expose
    var text: String? = null
}
