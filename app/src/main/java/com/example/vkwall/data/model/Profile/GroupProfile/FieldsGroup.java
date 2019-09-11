package com.example.vkwall.data.model.Profile.GroupProfile;

import com.google.gson.annotations.SerializedName;

public class FieldsGroup {
    @SerializedName("response")
    private ResponseGroup response;

    public ResponseGroup getResponse() {
        return response;
    }

    public void setResponse(ResponseGroup response) {
        this.response = response;
    }
}
