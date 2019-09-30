package com.example.vkwall.data.model.Recommended

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RepostsRecommended {
    @SerializedName("count")
    @Expose
    var count: Int? = null
    @SerializedName("user_reposted")
    @Expose
    var userReposted: Int? = null
}
