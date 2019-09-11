package com.example.vkwall.data.model.Profile.VideoProfile;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseVideo {
    @SerializedName("count")
    private Integer count;
    @SerializedName("items")
    private List<ItemVideo> items;
    @SerializedName("profiles")
    private List<ProfileVideo> profiles;
    @SerializedName("groups")
    private List<GroupVideo> groups;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ItemVideo> getItems() {
        return items;
    }

    public void setItems(List<ItemVideo> items) {
        this.items = items;
    }

    public List<ProfileVideo> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfileVideo> profiles) {
        this.profiles = profiles;
    }

    public List<GroupVideo> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupVideo> groups) {
        this.groups = groups;
    }
}
