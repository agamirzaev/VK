package com.example.vkwall.data.model.GetWallByID;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PhotoById {
    @SerializedName("id")
    private Integer id;
    @SerializedName("album_id")
    private Integer albumId;
    @SerializedName("owner_id")
    private Integer ownerId;
    @SerializedName("sizes")
    private List<SizeById> sizes;
    @SerializedName("text")
    private String text;
    @SerializedName("date")
    private Integer date;
    @SerializedName("post_id")
    private Integer postId;

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

    public List<SizeById> getSizes() {
        return sizes;
    }

    public void setSizes(List<SizeById> sizes) {
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

}
