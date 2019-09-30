package com.example.vkwall.data.model.ProfileWall.Wall;

import com.google.gson.annotations.SerializedName;

public class ViewsWall {

    @SerializedName("count")
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
