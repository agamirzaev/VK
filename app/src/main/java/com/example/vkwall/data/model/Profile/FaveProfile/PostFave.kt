package com.example.vkwall.data.model.Profile.FaveProfile

import com.google.gson.annotations.SerializedName

class PostFave {
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
    @SerializedName("attachments")
    var attachments: List<AttachmentFave>? = null
    @SerializedName("post_source")
    var postSource: PostSourceFave? = null
    @SerializedName("comments")
    var comments: CommentsFave? = null
    @SerializedName("likes")
    var likes: LikesFave? = null
    @SerializedName("reposts")
    var reposts: RepostsFave? = null
    @SerializedName("views")
    var views: ViewsFave? = null
    @SerializedName("is_favorite")
    var isFavorite: Boolean? = null
    @SerializedName("marked_as_ads")
    var markedAsAds: Int? = null

}
