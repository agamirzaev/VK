package com.example.vkwall.data.model.Profile.VideoProfile;

import com.google.gson.annotations.SerializedName;

public class LikesVideo {
    @SerializedName("user_likes")
    private Integer userLikes;
    @SerializedName("count")
    private Integer count;

    public Integer getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(Integer userLikes) {
        this.userLikes = userLikes;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
