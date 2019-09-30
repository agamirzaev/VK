package com.example.vkwall.data.model.Recommended

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseRecommended {
    @SerializedName("items")
    @Expose
    var items: List<ItemRecommended>? = null
    @SerializedName("profiles")
    @Expose
    var profiles: List<ProfileRecommended>? = null
    @SerializedName("groups")
    @Expose
    var groups: List<GroupRecommended>? = null
    @SerializedName("next_from")
    @Expose
    var nextFrom: String? = null
}
