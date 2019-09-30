package com.example.vkwall.data.model.ProfileWall.Comments

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Item {
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("from_id")
    @Expose
    var fromId: Int? = null
    @SerializedName("can_edit")
    @Expose
    var canEdit: Int? = null
    @SerializedName("post_id")
    @Expose
    var postId: Int? = null
    @SerializedName("owner_id")
    @Expose
    var ownerId: Int? = null
    @SerializedName("parents_stack")
    @Expose
    var parentsStack: List<Any>? = null
    @SerializedName("date")
    @Expose
    var date: Int? = null
    @SerializedName("text")
    @Expose
    var text: String? = null
    @SerializedName("likes")
    @Expose
    var likes: Likes? = null
    @SerializedName("thread")
    @Expose
    var thread: Thread? = null

    @SerializedName("attachments")
    @Expose
    var attachments: List<Attachment>? = null
}
