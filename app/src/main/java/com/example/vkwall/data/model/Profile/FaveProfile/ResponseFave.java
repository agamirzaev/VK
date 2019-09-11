package com.example.vkwall.data.model.Profile.FaveProfile;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseFave {
    @SerializedName("count")
    private Integer count;
    @SerializedName("items")
    private List<ItemFave> items;
    @SerializedName("profiles")
    private List<ProfileFave> profiles;
    @SerializedName("groups")
    private List<GroupFave> groups;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ItemFave> getItems() {
        return items;
    }

    public void setItems(List<ItemFave> items) {
        this.items = items;
    }

    public List<ProfileFave> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfileFave> profiles) {
        this.profiles = profiles;
    }

    public List<GroupFave> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupFave> groups) {
        this.groups = groups;
    }
}
