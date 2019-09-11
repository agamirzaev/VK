package com.example.vkwall.data.model.Profile.DocsProfile;

import com.google.gson.annotations.SerializedName;

public class FieldsDocs {

    @SerializedName("response")
    private ResponseDocs response;

    public ResponseDocs getResponse() {
        return response;
    }

    public void setResponse(ResponseDocs response) {
        this.response = response;
    }
}
