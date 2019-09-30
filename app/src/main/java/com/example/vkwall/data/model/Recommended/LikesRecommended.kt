package com.example.vkwall.data.model.Recommended

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LikesRecommended {
    @SerializedName("count")
    @Expose
    var count: Int? = null
    @SerializedName("user_likes")
    @Expose
    var userLikes: Int? = null
    @SerializedName("can_like")
    @Expose
    var canLike: Int? = null
    @SerializedName("can_publish")
    @Expose
    var canPublish: Int? = null
}
