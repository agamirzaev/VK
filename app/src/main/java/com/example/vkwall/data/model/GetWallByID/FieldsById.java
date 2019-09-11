package com.example.vkwall.data.model.GetWallByID;

import com.google.gson.annotations.SerializedName;

public class FieldsById {

    @SerializedName("response")
    private ResponseById response;

    public ResponseById getResponse() {
        return response;
    }

    public void setResponse(ResponseById response) {
        this.response = response;
    }

}
