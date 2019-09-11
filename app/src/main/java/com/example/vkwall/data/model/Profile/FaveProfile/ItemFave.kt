package com.example.vkwall.data.model.Profile.FaveProfile

import com.google.gson.annotations.SerializedName

class ItemFave {
    @SerializedName("type")
    var type: String? = null
    @SerializedName("seen")
    var seen: Boolean? = null
    @SerializedName("added_date")
    var addedDate: Int? = null
    @SerializedName("tags")
    var tags: List<Any>? = null
    @SerializedName("post")
    var post: PostFave? = null
    @SerializedName("video")
    var video: VideoFave? = null
}
