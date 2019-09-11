package com.example.vkwall.data.model.Notification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FieldsNotif {
    @SerializedName("response")
    @Expose
    private ResponseNotif response;

    public ResponseNotif getResponse() {
        return response;
    }

    public void setResponse(ResponseNotif response) {
        this.response = response;
    }

}
