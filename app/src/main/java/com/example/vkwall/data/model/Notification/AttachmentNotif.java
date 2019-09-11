package com.example.vkwall.data.model.Notification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AttachmentNotif {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("photo")
    @Expose
    private PhotoNotif photo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PhotoNotif getPhoto() {
        return photo;
    }

    public void setPhoto(PhotoNotif photo) {
        this.photo = photo;
    }

}
