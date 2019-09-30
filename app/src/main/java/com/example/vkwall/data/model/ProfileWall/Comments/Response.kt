package com.example.vkwall.data.model.ProfileWall.Comments

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Response {
    @SerializedName("count")
    @Expose
    var count: Int? = null
    @SerializedName("items")
    @Expose
    var items: List<Item>? = null
    @SerializedName("profiles")
    @Expose
    var profiles: List<Profile>? = null
    @SerializedName("groups")
    @Expose
    var groups: List<Groups>? = null
    @SerializedName("current_level_count")
    @Expose
    var currentLevelCount: Int? = null
    @SerializedName("can_post")
    @Expose
    var canPost: Boolean? = null
    @SerializedName("show_reply_button")
    @Expose
    var showReplyButton: Boolean? = null
    @SerializedName("groups_can_post")
    @Expose
    var groupsCanPost: Boolean? = null
}
