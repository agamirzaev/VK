package com.example.vkwall.data.model.LikeWalls;

import com.google.gson.annotations.SerializedName;

public class ResponseLike {

    @SerializedName("likes")
    private Integer likes;

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}
