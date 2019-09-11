package com.example.vkwall.data.model.Profile.DocsProfile;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseDocs {
    @SerializedName("count")
    private Integer count;
    @SerializedName("items")
    private List<ItemDocs> items;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ItemDocs> getItems() {
        return items;
    }

    public void setItems(List<ItemDocs> items) {
        this.items = items;
    }

}
