package com.example.vkwall.data.model.Profile.VideoProfile;

import com.google.gson.annotations.SerializedName;

public class FilesVideo {
    @SerializedName("mp4_240")
    private String mp4240;
    @SerializedName("mp4_360")
    private String mp4360;
    @SerializedName("mp4_480")
    private String mp4480;
    @SerializedName("mp4_720")
    private String mp4720;

    public String getMp4240() {
        return mp4240;
    }

    public void setMp4240(String mp4240) {
        this.mp4240 = mp4240;
    }

    public String getMp4360() {
        return mp4360;
    }

    public void setMp4360(String mp4360) {
        this.mp4360 = mp4360;
    }

    public String getMp4480() {
        return mp4480;
    }

    public void setMp4480(String mp4480) {
        this.mp4480 = mp4480;
    }

    public String getMp4720() {
        return mp4720;
    }

    public void setMp4720(String mp4720) {
        this.mp4720 = mp4720;
    }

}
