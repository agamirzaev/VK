package com.example.vkwall.data.model.ProfileWall;

import com.google.gson.annotations.SerializedName;

public class PostSource {
    @SerializedName("type")
    private String type;
    @SerializedName("platform")
    private String platform;
    @SerializedName("data")
    private String data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
