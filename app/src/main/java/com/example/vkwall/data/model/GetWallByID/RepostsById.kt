package com.example.vkwall.data.model.GetWallByID

import com.google.gson.annotations.SerializedName

class RepostsById {
    @SerializedName("count")
    var count: Int? = null
    @SerializedName("user_reposted")
    var userReposted: Int? = null
}
