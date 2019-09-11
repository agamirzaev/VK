package com.example.vkwall.data.model.Profile.FaveProfile;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhotoFave {
    @SerializedName("id")
    private Integer id;
    @SerializedName("album_id")
    private Integer albumId;
    @SerializedName("owner_id")
    private Integer ownerId;
    @SerializedName("sizes")
    private List<SizeFave> sizes;
    @SerializedName("text")
    private String text;
    @SerializedName("date")
    private Integer date;
    @SerializedName("access_key")
    private String accessKey;
    @SerializedName("user_id")
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public List<SizeFave> getSizes() {
        return sizes;
    }

    public void setSizes(List<SizeFave> sizes) {
        this.sizes = sizes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
