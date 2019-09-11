package com.example.vkwall.data.model.Profile.GroupProfile;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseGroup {
    @SerializedName("count")
    private Integer count;
    @SerializedName("items")
    private List<ItemGroup> items;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ItemGroup> getItems() {
        return items;
    }

    public void setItems(List<ItemGroup> items) {
        this.items = items;
    }

}
