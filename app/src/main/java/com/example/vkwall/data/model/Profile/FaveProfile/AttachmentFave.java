package com.example.vkwall.data.model.Profile.FaveProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AttachmentFave {
    @SerializedName("type")
    private String type;
    @SerializedName("photo")
    private PhotoFave photo;
    @SerializedName("video")
    private VideoFave video;
    @SerializedName("doc")
    @Expose
    private DocFave doc;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PhotoFave getPhoto() {
        return photo;
    }

    public void setPhoto(PhotoFave photo) {
        this.photo = photo;
    }

    public VideoFave getVideo() {
        return video;
    }

    public void setVideo(VideoFave video) {
        this.video = video;
    }

    public DocFave getDoc() {
        return doc;
    }

    public void setDoc(DocFave doc) {
        this.doc = doc;
    }
}
