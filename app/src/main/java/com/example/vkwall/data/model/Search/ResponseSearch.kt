package com.example.vkwall.data.model.Search

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseSearch {
    @SerializedName("count")
    @Expose
    var count: Int? = null
    @SerializedName("items")
    @Expose
    var items: List<ItemSearch>? = null
}
