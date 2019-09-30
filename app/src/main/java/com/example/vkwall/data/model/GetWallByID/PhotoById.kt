package com.example.vkwall.data.model.GetWallByID

import com.google.gson.annotations.SerializedName

import java.util.ArrayList

class PhotoById {
    @SerializedName("id")
    var id: Int? = null
    @SerializedName("album_id")
    var albumId: Int? = null
    @SerializedName("owner_id")
    var ownerId: Int? = null
    @SerializedName("sizes")
    var sizes: List<SizeById>? = null
    @SerializedName("text")
    var text: String? = null
    @SerializedName("date")
    var date: Int? = null
    @SerializedName("post_id")
    var postId: Int? = null

}
