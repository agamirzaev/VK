package com.example.vkwall.data.model.GetWallByID

import com.google.gson.annotations.SerializedName

class CommentsById {
    @SerializedName("count")
    var count: Int? = null
    @SerializedName("can_post")
    var canPost: Int? = null
    @SerializedName("groups_can_post")
    var groupsCanPost: Boolean? = null
    @SerializedName("can_close")
    var canClose: Int? = null

}
