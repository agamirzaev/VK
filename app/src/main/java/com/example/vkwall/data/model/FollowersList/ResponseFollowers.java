package com.example.vkwall.data.model.FollowersList;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResponseFollowers {
    @SerializedName("count")
    private Integer count;
    @SerializedName("items")
    private List<ItemFollowers> items = new ArrayList<>();

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ItemFollowers> getItems() {
        return items;
    }

    public void setItems(List<ItemFollowers> items) {
        this.items = items;
    }
}
