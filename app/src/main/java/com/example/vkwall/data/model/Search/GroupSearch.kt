package com.example.vkwall.data.model.Search

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GroupSearch {
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("screen_name")
    @Expose
    var screenName: String? = null
    @SerializedName("is_closed")
    @Expose
    var isClosed: Int? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("is_admin")
    @Expose
    var isAdmin: Int? = null
    @SerializedName("is_member")
    @Expose
    var isMember: Int? = null
    @SerializedName("is_advertiser")
    @Expose
    var isAdvertiser: Int? = null
    @SerializedName("photo_50")
    @Expose
    var photo50: String? = null
}
