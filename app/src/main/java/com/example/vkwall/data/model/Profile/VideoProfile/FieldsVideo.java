package com.example.vkwall.data.model.Profile.VideoProfile;

import com.google.gson.annotations.SerializedName;

public class FieldsVideo {
    @SerializedName("response")
    private ResponseVideo response;

    public ResponseVideo getResponse() {
        return response;
    }

    public void setResponse(ResponseVideo response) {
        this.response = response;
    }

}
