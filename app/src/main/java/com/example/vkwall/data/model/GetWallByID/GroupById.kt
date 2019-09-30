package com.example.vkwall.data.model.GetWallByID

import com.google.gson.annotations.SerializedName

class GroupById {
    @SerializedName("id")
    var id: Int? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("screen_name")
    var screenName: String? = null
    @SerializedName("is_closed")
    var isClosed: Int? = null
    @SerializedName("type")
    var type: String? = null
    @SerializedName("is_admin")
    var isAdmin: Int? = null
    @SerializedName("is_member")
    var isMember: Int? = null
    @SerializedName("is_advertiser")
    var isAdvertiser: Int? = null
    @SerializedName("photo_50")
    var photo50: String? = null
    @SerializedName("photo_100")
    var photo100: String? = null
    @SerializedName("photo_200")
    var photo200: String? = null

}
