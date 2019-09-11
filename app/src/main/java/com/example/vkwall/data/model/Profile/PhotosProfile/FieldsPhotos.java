package com.example.vkwall.data.model.Profile.PhotosProfile;

import com.google.gson.annotations.SerializedName;

public class FieldsPhotos {

    @SerializedName("response")
    private ResponsePhotos response;

    public ResponsePhotos getResponse() {
        return response;
    }

    public void setResponse(ResponsePhotos response) {
        this.response = response;
    }

}
