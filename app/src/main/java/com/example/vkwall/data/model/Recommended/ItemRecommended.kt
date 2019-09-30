package com.example.vkwall.data.model.Recommended

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemRecommended {
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("source_id")
    @Expose
    var sourceId: Int? = null
    @SerializedName("date")
    @Expose
    var date: Int? = null
    @SerializedName("post_type")
    @Expose
    var postType: String? = null
    @SerializedName("text")
    @Expose
    var text: String? = null
    @SerializedName("marked_as_ads")
    @Expose
    var markedAsAds: Int? = null
    @SerializedName("attachments")
    @Expose
    var attachments: List<AttachmentRecommended>? = null
    @SerializedName("post_source")
    @Expose
    var postSource: PostSource? = null
    @SerializedName("comments")
    @Expose
    var comments: CommentsRecommended? = null
    @SerializedName("likes")
    @Expose
    var likes: LikesRecommended? = null
    @SerializedName("reposts")
    @Expose
    var reposts: RepostsRecommended? = null
    @SerializedName("views")
    @Expose
    var views: ViewsRecommended? = null
    @SerializedName("is_favorite")
    @Expose
    var isFavorite: Boolean? = null
    @SerializedName("post_id")
    @Expose
    var postId: Int? = null
}
