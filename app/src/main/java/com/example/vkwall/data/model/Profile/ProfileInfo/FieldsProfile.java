package com.example.vkwall.data.model.Profile.ProfileInfo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FieldsProfile {
    @SerializedName("response")
    private List<Response> response ;

    public List<Response> getResponse() {
        return response;
    }

    public void setResponse(List<Response> response) {
        this.response = response;
    }
}
