package com.example.vkwall.data.model.Profile.FaveProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PreviewFave {
    @SerializedName("photo")
    @Expose
    private PhotoPreview photo;
    @SerializedName("video")
    @Expose
    private VideoPreview video;

    public PhotoPreview getPhoto() {
        return photo;
    }

    public void setPhoto(PhotoPreview photo) {
        this.photo = photo;
    }

    public VideoPreview getVideo() {
        return video;
    }

    public void setVideo(VideoPreview video) {
        this.video = video;
    }

}
