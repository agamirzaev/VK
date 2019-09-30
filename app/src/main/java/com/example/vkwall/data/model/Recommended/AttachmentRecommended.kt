package com.example.vkwall.data.model.Recommended

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AttachmentRecommended {
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("photo")
    @Expose
    var photo: PhotoRecommended? = null
    @SerializedName("podcast")
    @Expose
    var podcast: PodCastRecommended? = null
}
