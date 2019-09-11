package com.example.vkwall.data.model.Profile.FaveProfile;

import com.google.gson.annotations.SerializedName;

public class LikesFave {
    @SerializedName("count")
    private Integer count;
    @SerializedName("user_likes")
    private Integer userLikes;
    @SerializedName("can_like")
    private Integer canLike;
    @SerializedName("can_publish")
    private Integer canPublish;

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

    public Integer getCanLike() {
        return canLike;
    }

    public void setCanLike(Integer canLike) {
        this.canLike = canLike;
    }

    public Integer getCanPublish() {
        return canPublish;
    }

    public void setCanPublish(Integer canPublish) {
        this.canPublish = canPublish;
    }
}
