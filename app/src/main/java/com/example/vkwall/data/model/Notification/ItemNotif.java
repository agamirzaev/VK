package com.example.vkwall.data.model.Notification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemNotif {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("date")
    @Expose
    private Integer date;
    @SerializedName("parent")
    @Expose
    private ParentNotif parent;
    @SerializedName("feedback")
    @Expose
    private FeedbackNotif feedback;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public ParentNotif getParent() {
        return parent;
    }

    public void setParent(ParentNotif parent) {
        this.parent = parent;
    }

    public FeedbackNotif getFeedback() {
        return feedback;
    }

    public void setFeedback(FeedbackNotif feedback) {
        this.feedback = feedback;
    }

}
