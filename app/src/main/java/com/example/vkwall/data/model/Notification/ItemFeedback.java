package com.example.vkwall.data.model.Notification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemFeedback {

    @SerializedName("from_id")
    @Expose
    private Integer fromId;

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }


}
