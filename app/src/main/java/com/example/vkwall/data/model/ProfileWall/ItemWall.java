package com.example.vkwall.data.model.ProfileWall;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemWall {
    @SerializedName("id")
    private Integer id;
    @SerializedName("from_id")
    private Integer fromId;
    @SerializedName("owner_id")
    private Integer ownerId;
    @SerializedName("date")
    private Integer date;
    @SerializedName("post_type")
    private String postType;
    @SerializedName("text")
    private String text;
    @SerializedName("attachments")
    private List<AttachmentWall> attachments;
    @SerializedName("copy_history")
    private List<CopyHistoryWall> copyHistory;
    @SerializedName("post_source")
    private PostSource postSource;
    @SerializedName("comments")
    private CommentsWall comments;
    @SerializedName("likes")
    private LikesWall likes;
    @SerializedName("reposts")
    private RepostsWall reposts;
    @SerializedName("views")
    private ViewsWall views;
    @SerializedName("is_favorite")
    private Boolean isFavorite;

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

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
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

    public CommentsWall getComments() {
        return comments;
    }

    public void setComments(CommentsWall comments) {
        this.comments = comments;
    }

    public LikesWall getLikes() {
        return likes;
    }

    public void setLikes(LikesWall likes) {
        this.likes = likes;
    }

    public RepostsWall getReposts() {
        return reposts;
    }

    public void setReposts(RepostsWall reposts) {
        this.reposts = reposts;
    }

    public ViewsWall getViews() {
        return views;
    }

    public void setViews(ViewsWall views) {
        this.views = views;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public List<CopyHistoryWall> getCopyHistory() {
        return copyHistory;
    }

    public void setCopyHistory(List<CopyHistoryWall> copyHistory) {
        this.copyHistory = copyHistory;
    }
}
