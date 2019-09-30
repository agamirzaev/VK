package com.example.vkwall.data.model.ProfileWall.Wall

import com.google.gson.annotations.SerializedName

class AudioWall {
    @SerializedName("artist")
    var artist: String? = null
    @SerializedName("id")
    var id: Int? = null
    @SerializedName("owner_id")
    var ownerId: Int? = null
    @SerializedName("title")
    var title: String? = null
    @SerializedName("duration")
    var duration: Int? = null
    @SerializedName("track_code")
    var trackCode: String? = null
    @SerializedName("url")
    var url: String? = null
    @SerializedName("date")
    var date: Int? = null
    @SerializedName("genre_id")
    var genreId: Int? = null

}
