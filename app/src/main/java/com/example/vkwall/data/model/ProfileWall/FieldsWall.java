package com.example.vkwall.data.model.ProfileWall;

import com.google.gson.annotations.SerializedName;

public class FieldsWall {

    @SerializedName("response")
    private ResponseWall response;

    public ResponseWall getResponse() {
        return response;
    }

    public void setResponse(ResponseWall response) {
        this.response = response;
    }
}
