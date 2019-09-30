package com.example.vkwall.data.model.ProfileWall.Wall;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CopyHistoryWall {
    @SerializedName("id")
    private Integer id;
    @SerializedName("owner_id")
    private Integer ownerId;
    @SerializedName("from_id")
    private Integer fromId;
    @SerializedName("date")
    private Integer date;
    @SerializedName("post_type")
    private String postType;
    @SerializedName("text")
    private String text;
    @SerializedName("attachments")
    private List<AttachmentWall> attachments;
    @SerializedName("post_source")
    private PostSource postSource;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<AttachmentWall> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<AttachmentWall> attachments) {
        this.attachments = attachments;
    }

    public PostSource getPostSource() {
        return postSource;
    }

    public void setPostSource(PostSource postSource) {
        this.postSource = postSource;
    }
}
