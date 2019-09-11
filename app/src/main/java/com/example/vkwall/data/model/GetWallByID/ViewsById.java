package com.example.vkwall.data.model.GetWallByID;

import com.google.gson.annotations.SerializedName;

public class ViewsById {
    @SerializedName("count")
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
