package com.example.vkwall.data.model.FollowersList;

import com.google.gson.annotations.SerializedName;

public class FieldsFollowers {

    @SerializedName("response")
    private ResponseFollowers response;

    public ResponseFollowers getResponse() {
        return response;
    }

    public void setResponse(ResponseFollowers response) {
        this.response = response;
    }

}
