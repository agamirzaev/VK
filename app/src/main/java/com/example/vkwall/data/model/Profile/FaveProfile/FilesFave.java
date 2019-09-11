package com.example.vkwall.data.model.Profile.FaveProfile;

import com.google.gson.annotations.SerializedName;

public class FilesFave {
    @SerializedName("external")
    private String external;
    @SerializedName("live")
    private String live;
    @SerializedName("hls")
    private String hls;

    public String getExternal() {
        return external;
    }

    public void setExternal(String external) {
        this.external = external;
    }

    public String getLive() {
        return live;
    }

    public void setLive(String live) {
        this.live = live;
    }

    public String getHls() {
        return hls;
    }

    public void setHls(String hls) {
        this.hls = hls;
    }
}
