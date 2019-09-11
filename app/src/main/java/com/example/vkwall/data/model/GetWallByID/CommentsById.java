package com.example.vkwall.data.model.GetWallByID;

import com.google.gson.annotations.SerializedName;

public class CommentsById {
    @SerializedName("count")
    private Integer count;
    @SerializedName("can_post")
    private Integer canPost;
    @SerializedName("groups_can_post")
    private Boolean groupsCanPost;
    @SerializedName("can_close")
    private Integer canClose;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCanPost() {
        return canPost;
    }

    public void setCanPost(Integer canPost) {
        this.canPost = canPost;
    }

    public Boolean getGroupsCanPost() {
        return groupsCanPost;
    }

    public void setGroupsCanPost(Boolean groupsCanPost) {
        this.groupsCanPost = groupsCanPost;
    }

    public Integer getCanClose() {
        return canClose;
    }

    public void setCanClose(Integer canClose) {
        this.canClose = canClose;
    }

}
