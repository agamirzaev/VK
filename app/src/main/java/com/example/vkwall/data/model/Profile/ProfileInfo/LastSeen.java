package com.example.vkwall.data.model.Profile.ProfileInfo;

import com.google.gson.annotations.SerializedName;

public class LastSeen {
    @SerializedName("time")
    private Integer time;
    @SerializedName("platform")
    private Integer platform;

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }
}
