package com.example.vkwall.data.model.LikeWalls;

import com.google.gson.annotations.SerializedName;

public class FieldsLike {
    @SerializedName("response")
    private ResponseLike response;

    public ResponseLike getResponse() {
        return response;
    }

    public void setResponse(ResponseLike response) {
        this.response = response;
    }
}
