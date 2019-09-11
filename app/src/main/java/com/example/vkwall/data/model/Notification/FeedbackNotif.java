package com.example.vkwall.data.model.Notification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FeedbackNotif {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("from_id")
    @Expose
    private Integer fromId;
    @SerializedName("post_id")
    @Expose
    private Integer postId;
    @SerializedName("owner_id")
    @Expose
    private Integer ownerId;
    @SerializedName("parents_stack")
    @Expose
    private List<Object> parentsStack;
    @SerializedName("date")
    @Expose
    private Integer date;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("thread")
    @Expose
    private Thread thread;
    @SerializedName("likes")
    @Expose
    private LikesFeedback likes;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("items")
    @Expose
    private List<ItemFeedback> items = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public List<Object> getParentsStack() {
        return parentsStack;
    }

    public void setParentsStack(List<Object> parentsStack) {
        this.parentsStack = parentsStack;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public LikesFeedback getLikes() {
        return likes;
    }

    public void setLikes(LikesFeedback likes) {
        this.likes = likes;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ItemFeedback> getItems() {
        return items;
    }

    public void setItems(List<ItemFeedback> items) {
        this.items = items;
    }

}
