package com.example.vkwall.data.model.Notification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseNotif {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("items")
    @Expose
    private List<ItemNotif> items = null;
    @SerializedName("profiles")
    @Expose
    private List<ProfileNotif> profiles;
    @SerializedName("groups")
    @Expose
    private List<Object> groups;
    @SerializedName("last_viewed")
    @Expose
    private Integer lastViewed;
    @SerializedName("next_from")
    @Expose
    private String nextFrom;
    @SerializedName("ttl")
    @Expose
    private Integer ttl;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ItemNotif> getItems() {
        return items;
    }

    public void setItems(List<ItemNotif> items) {
        this.items = items;
    }

    public List<ProfileNotif> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfileNotif> profiles) {
        this.profiles = profiles;
    }

    public List<Object> getGroups() {
        return groups;
    }

    public void setGroups(List<Object> groups) {
        this.groups = groups;
    }

    public Integer getLastViewed() {
        return lastViewed;
    }

    public void setLastViewed(Integer lastViewed) {
        this.lastViewed = lastViewed;
    }

    public String getNextFrom() {
        return nextFrom;
    }

    public void setNextFrom(String nextFrom) {
        this.nextFrom = nextFrom;
    }

    public Integer getTtl() {
        return ttl;
    }

    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

}
