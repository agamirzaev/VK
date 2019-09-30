package com.example.vkwall.data.model.ProfileWall.Wall;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhotoWall {
    @SerializedName("id")
    private Integer id;
    @SerializedName("album_id")
    private Integer albumId;
    @SerializedName("owner_id")
    private Integer ownerId;
    @SerializedName("sizes")
    private List<SizeWall> sizes;
    @SerializedName("text")
    private String text;
    @SerializedName("date")
    private Integer date;
    @SerializedName("post_id")
    private Integer postId;
    @SerializedName("access_key")
    private String accessKey;

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

    public List<SizeWall> getSizes() {
        return sizes;
    }

    public void setSizes(List<SizeWall> sizes) {
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

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }
}
