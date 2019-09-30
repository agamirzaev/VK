package com.example.vkwall.data.model.Recommended

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CommentsRecommended {
    @SerializedName("count")
    @Expose
    var count: Int? = null
    @SerializedName("can_post")
    @Expose
    var canPost: Int? = null
    @SerializedName("groups_can_post")
    @Expose
    var groupsCanPost: Boolean? = null
}
