package com.example.vkwall.data.model.GetWallByID;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResponseById {

    @SerializedName("items")
    private List<ItemById> items;
    @SerializedName("profiles")
    private List<ProfileById> profiles;
    @SerializedName("groups")
    private List<GroupById> groups;

    public List<ItemById> getItems() {
        return items;
    }

    public void setItems(List<ItemById> items) {
        this.items = items;
    }

    public List<ProfileById> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfileById> profiles) {
        this.profiles = profiles;
    }

    public List<GroupById> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupById> groups) {
        this.groups = groups;
    }

}
