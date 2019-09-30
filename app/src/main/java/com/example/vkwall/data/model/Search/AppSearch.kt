package com.example.vkwall.data.model.Search

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AppSearch {
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("track_code")
    @Expose
    var trackCode: String? = null
    @SerializedName("icon_139")
    @Expose
    var icon139: String? = null
    @SerializedName("icon_150")
    @Expose
    var icon150: String? = null
    @SerializedName("icon_278")
    @Expose
    var icon278: String? = null
    @SerializedName("icon_75")
    @Expose
    var icon75: String? = null
    @SerializedName("author_group")
    @Expose
    var authorGroup: Int? = null
    @SerializedName("author_url")
    @Expose
    var authorUrl: String? = null
    @SerializedName("banner_1120")
    @Expose
    var banner1120: String? = null
    @SerializedName("banner_560")
    @Expose
    var banner560: String? = null
    @SerializedName("catalog_banner")
    @Expose
    var catalogBanner: CatalogBannerSearch? = null
    @SerializedName("is_in_catalog")
    @Expose
    var isInCatalog: Int? = null
    @SerializedName("installed")
    @Expose
    var installed: Boolean? = null
    @SerializedName("leaderboard_type")
    @Expose
    var leaderboardType: Int? = null
    @SerializedName("members_count")
    @Expose
    var membersCount: Int? = null
    @SerializedName("section")
    @Expose
    var section: String? = null
    @SerializedName("hide_tabbar")
    @Expose
    var hideTabbar: Int? = null
}
