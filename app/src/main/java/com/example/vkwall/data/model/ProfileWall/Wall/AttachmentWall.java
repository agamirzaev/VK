package com.example.vkwall.data.model.ProfileWall.Wall;

import com.google.gson.annotations.SerializedName;

public class AttachmentWall {
    @SerializedName("type")
    private String type;
    @SerializedName("video")
    private VideoWall video;
    @SerializedName("photo")
    private PhotoWall photo;
    @SerializedName("audio")
    private AudioWall audio;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PhotoWall getPhoto() {
        return photo;
    }

    public void setPhoto(PhotoWall photo) {
        this.photo = photo;
    }

    public VideoWall getVideo() {
        return video;
    }

    public void setVideo(VideoWall video) {
        this.video = video;
    }

    public AudioWall getAudio() {
        return audio;
    }

    public void setAudio(AudioWall audio) {
        this.audio = audio;
    }
}
