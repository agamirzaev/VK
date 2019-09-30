package com.example.vkwall.data.model.ProfileWall.Wall;

import com.google.gson.annotations.SerializedName;

public class CommentsWall {
    @SerializedName("count")
    private Integer count;
    @SerializedName("can_post")
    private Integer canPost;
    @SerializedName("groups_can_post")
    private Boolean groupsCanPost;

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
}
