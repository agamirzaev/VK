package com.example.vkwall.data.model.Profile.DeleteFriends

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResponseDelete {
    @SerializedName("success")
    @Expose
    var success: Int? = null
    @SerializedName("friend_deleted")
    @Expose
    var friendDeleted: Int? = null
}
