package com.example.vkwall.data.model.GetWallByID

import com.google.gson.annotations.SerializedName

import java.util.ArrayList

class ResponseById {

    @SerializedName("items")
    var items: List<ItemById>? = null
    @SerializedName("profiles")
    var profiles: List<ProfileById>? = null
    @SerializedName("groups")
    var groups: List<GroupById>? = null

}
