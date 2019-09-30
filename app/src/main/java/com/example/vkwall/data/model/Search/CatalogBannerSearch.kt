package com.example.vkwall.data.model.Search

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CatalogBannerSearch {
    @SerializedName("background_color")
    @Expose
    var backgroundColor: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("description_color")
    @Expose
    var descriptionColor: String? = null
    @SerializedName("title_color")
    @Expose
    var titleColor: String? = null
}
