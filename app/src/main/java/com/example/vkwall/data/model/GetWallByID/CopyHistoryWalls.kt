package com.example.vkwall.data.model.GetWallByID

import com.example.vkwall.data.model.ProfileWall.Wall.PostSource
import com.google.gson.annotations.SerializedName

class CopyHistoryWalls {
    @SerializedName("id")
    var id: Int? = null
    @SerializedName("owner_id")
    var ownerId: Int? = null
    @SerializedName("from_id")
    var fromId: Int? = null
    @SerializedName("date")
    var date: Int? = null
    @SerializedName("post_type")
    var postType: String? = null
    @SerializedName("text")
    var text: String? = null
    @SerializedName("attachments")
    var attachments: List<AttachmentById>? = null
    @SerializedName("post_source")
    var postSource: PostSource? = null
}
