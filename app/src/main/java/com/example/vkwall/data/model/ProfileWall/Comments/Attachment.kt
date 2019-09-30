package com.example.vkwall.data.model.ProfileWall.Comments

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Attachment {
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("sticker")
    @Expose
    var sticker: Sticker? = null
}
