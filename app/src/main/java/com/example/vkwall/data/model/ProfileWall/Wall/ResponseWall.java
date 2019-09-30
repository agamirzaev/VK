package com.example.vkwall.data.model.ProfileWall.Wall;

import com.example.vkwall.data.model.ProfileWall.Wall.GroupWall;
import com.example.vkwall.data.model.ProfileWall.Wall.ItemWall;
import com.example.vkwall.data.model.ProfileWall.Wall.ProfileWall;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseWall {
    @SerializedName("count")
    private Integer count;
    @SerializedName("items")
    private List<ItemWall> items;
    @SerializedName("profiles")
    private List<ProfileWall> profiles;
    @SerializedName("groups")
    private List<GroupWall> groups;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ItemWall> getItems() {
        return items;
    }

    public void setItems(List<ItemWall> items) {
        this.items = items;
    }

    public List<ProfileWall> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfileWall> profiles) {
        this.profiles = profiles;
    }

    public List<GroupWall> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupWall> groups) {
        this.groups = groups;
    }
}
