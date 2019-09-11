package com.example.vkwall.data.model.FriendsInfo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FieldsFriendsInfo {
    @SerializedName("response")
    private List<FriendsInfo> response;

    public List<FriendsInfo> getResponse() {
        return response;
    }

    public void setResponse(List<FriendsInfo> response) {
        this.response = response;
    }
}
