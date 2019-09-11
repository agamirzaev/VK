package com.example.vkwall.data.model.Profile.FaveProfile;

import com.google.gson.annotations.SerializedName;

public class FieldsFave {
    @SerializedName("response")
    private ResponseFave response;

    public ResponseFave getResponse() {
        return response;
    }

    public void setResponse(ResponseFave response) {
        this.response = response;
    }
}
