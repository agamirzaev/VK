package com.example.vkwall.data.model.GetWallByID

import com.google.gson.annotations.SerializedName

import java.util.ArrayList

class ItemById {
    @SerializedName("id")
    var id: Int? = null
    @SerializedName("from_id")
    var fromId: Int? = null
    @SerializedName("owner_id")
    var ownerId: Int? = null
    @SerializedName("date")
    var date: Int? = null
    @SerializedName("post_type")
    var postType: String? = null
    @SerializedName("text")
    var text: String? = null
    @SerializedName("can_delete")
    var canDelete: Int? = null
    @SerializedName("can_pin")
    var canPin: Int? = null
    @SerializedName("can_archive")
    var canArchive: Boolean? = null
    @SerializedName("is_archived")
    var isArchived: Boolean? = null
    @SerializedName("attachments")
    var attachments: List<AttachmentById>? = null
    @SerializedName("copy_history")
    var copyHistoryWalls: List<CopyHistoryWalls>? = null
    @SerializedName("comments")
    var comments: CommentsById? = null
    @SerializedName("likes")
    var likes: LikesById? = null
    @SerializedName("reposts")
    var reposts: RepostsById? = null
    @SerializedName("views")
    var views: ViewsById? = null
    @SerializedName("is_favorite")
    var isFavorite: Boolean? = null
}
