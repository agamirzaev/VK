package com.example.vkwall.data.model.FriendsList;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResponseFriends {
    @SerializedName("count")
    private Integer count;
    @SerializedName("items")
    private List<ItemFriends> items;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ItemFriends> getItems() {
        return items;
    }

    public void setItems(List<ItemFriends> items) {
        this.items = items;
    }
}
