package com.example.vkwall.data.model.Search

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.example.vkwall.ul.App


class ItemSearch {
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("app")
    @Expose
    val app: AppSearch? = null
    @SerializedName("group")
    @Expose
    var group: GroupSearch? = null
    @SerializedName("profile")
    @Expose
    var profile: ProfileSearch? = null
    @SerializedName("section")
    @Expose
    var section: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("global")
    @Expose
    var global: Int? = null
}
