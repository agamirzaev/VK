package com.example.vkwall.data.model.Profile.VideoProfile;

import com.google.gson.annotations.SerializedName;

public class ImageVideo {
    @SerializedName("height")
    private Integer height;
    @SerializedName("url")
    private String url;
    @SerializedName("width")
    private Integer width;
    @SerializedName("with_padding")
    private Integer withPadding;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getWithPadding() {
        return withPadding;
    }

    public void setWithPadding(Integer withPadding) {
        this.withPadding = withPadding;
    }
}
