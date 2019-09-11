package com.example.vkwall.data.model.GetWallByID;

import com.google.gson.annotations.SerializedName;

public class AttachmentById {
    @SerializedName("type")
    private String type;
    @SerializedName("photo")
    private PhotoById photo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PhotoById getPhoto() {
        return photo;
    }

    public void setPhoto(PhotoById photo) {
        this.photo = photo;
    }

}
