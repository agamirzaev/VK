package com.example.vkwall.data.model.Profile.PhotosProfile;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponsePhotos {
    @SerializedName("count")
    private Integer count;
    @SerializedName("items")
    private List<ItemPhotos> items;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ItemPhotos> getItems() {
        return items;
    }

    public void setItems(List<ItemPhotos> items) {
        this.items = items;
    }
}
