package com.example.vkwall.data.model.Recommended

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PodCastRecommended {
    @SerializedName("artist")
    @Expose
    var artist: String? = null
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("owner_id")
    @Expose
    var ownerId: Int? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("duration")
    @Expose
    var duration: Int? = null
    @SerializedName("track_code")
    @Expose
    var trackCode: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("date")
    @Expose
    var date: Int? = null
    @SerializedName("lyrics_id")
    @Expose
    var lyricsId: Int? = null
    @SerializedName("no_search")
    @Expose
    var noSearch: Int? = null
    @SerializedName("podcast_info")
    @Expose
    var podcastInfo: PodCastInfo? = null
}
