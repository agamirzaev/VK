package com.example.vkwall.data.model.Notification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LikesFeedback {
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("user_likes")
    @Expose
    private Integer userLikes;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(Integer userLikes) {
        this.userLikes = userLikes;
    }

}
