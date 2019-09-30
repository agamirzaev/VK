package com.example.vkwall.data.model.GetWallByID

import com.example.vkwall.data.model.ProfileWall.Wall.AudioWall
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AttachmentById {
    @SerializedName("type")
    var type: String? = null
    @SerializedName("audio")
    @Expose
    var audio: AudioWall? = null
    @SerializedName("photo")
    var photo: PhotoById? = null
}
