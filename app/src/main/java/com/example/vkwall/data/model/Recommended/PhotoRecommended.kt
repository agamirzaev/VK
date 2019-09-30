package com.example.vkwall.data.model.Recommended

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PhotoRecommended {
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("album_id")
    @Expose
    var albumId: Int? = null
    @SerializedName("owner_id")
    @Expose
    var ownerId: Int? = null
    @SerializedName("user_id")
    @Expose
    var userId: Int? = null
    @SerializedName("sizes")
    @Expose
    var sizes: List<SizeRecommended>? = null
    @SerializedName("text")
    @Expose
    var text: String? = null
    @SerializedName("date")
    @Expose
    var date: Int? = null
    @SerializedName("access_key")
    @Expose
    var accessKey: String? = null
    @SerializedName("post_id")
    @Expose
    var postId: Int? = null
}
