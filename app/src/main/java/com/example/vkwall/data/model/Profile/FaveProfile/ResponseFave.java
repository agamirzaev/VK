package com.example.vkwall.data.model.Profile.FaveProfile;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResponseFave {
    @SerializedName("count")
    private Integer count;
    @SerializedName("items")
    private ArrayList<ItemFave> items;
    @SerializedName("profiles")
    private ArrayList<ProfileFave> profiles;
    @SerializedName("groups")
    private ArrayList<GroupFave> groups;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public ArrayList<ItemFave> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemFave> items) {
        this.items = items;
    }

    public ArrayList<ProfileFave> getProfiles() {
        return profiles;
    }

    public void setProfiles(ArrayList<ProfileFave> profiles) {
        this.profiles = profiles;
    }

    public ArrayList<GroupFave> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<GroupFave> groups) {
        this.groups = groups;
    }
}
