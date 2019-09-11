package com.example.vkwall.data.model.FriendsList;

import com.google.gson.annotations.SerializedName;

public class FieldsFriends {
    @SerializedName("response")
    private ResponseFriends response;

    public ResponseFriends getResponse() {
        return response;
    }

    public void setResponse(ResponseFriends response) {
        this.response = response;
    }
}
