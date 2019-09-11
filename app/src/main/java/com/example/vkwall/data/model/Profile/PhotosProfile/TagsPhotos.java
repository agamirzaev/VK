package com.example.vkwall.data.model.Profile.PhotosProfile;

import com.google.gson.annotations.SerializedName;

public class TagsPhotos {
    @SerializedName("count")
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
