package com.example.vkwall.data.model.Profile.ProfileInfo;

import android.graphics.Rect;

import com.google.gson.annotations.SerializedName;

public class CropPhoto {
    @SerializedName("photo")
    private Photo photo;
    @SerializedName("crop")
    private Crop crop;
    @SerializedName("rect")
    private Rect rect;

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public Rect getRect() {
        return rect;
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }
}
