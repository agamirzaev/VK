package com.example.vkwall.data.model.GetWallByID;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ItemById {
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
    @SerializedName("can_delete")
    private Integer canDelete;
    @SerializedName("can_pin")
    private Integer canPin;
    @SerializedName("can_archive")
    private Boolean canArchive;
    @SerializedName("is_archived")
    private Boolean isArchived;
    @SerializedName("attachments")
    private List<AttachmentById> attachments;
    @SerializedName("copy_history")
    private List<CopyHistoryWalls> copyHistoryWalls;
    @SerializedName("comments")
    private CommentsById comments;
    @SerializedName("likes")
    private LikesById likes;
    @SerializedName("reposts")
    private RepostsById reposts;
    @SerializedName("views")
    private ViewsById views;
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

    public Integer getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(Integer canDelete) {
        this.canDelete = canDelete;
    }

    public Integer getCanPin() {
        return canPin;
    }

    public void setCanPin(Integer canPin) {
        this.canPin = canPin;
    }

    public Boolean getCanArchive() {
        return canArchive;
    }

    public void setCanArchive(Boolean canArchive) {
        this.canArchive = canArchive;
    }

    public Boolean getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(Boolean isArchived) {
        this.isArchived = isArchived;
    }

    public List<AttachmentById> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<AttachmentById> attachments) {
        this.attachments = attachments;
    }

    public CommentsById getComments() {
        return comments;
    }

    public void setComments(CommentsById comments) {
        this.comments = comments;
    }

    public LikesById getLikes() {
        return likes;
    }

    public void setLikes(LikesById likes) {
        this.likes = likes;
    }

    public RepostsById getReposts() {
        return reposts;
    }

    public void setReposts(RepostsById reposts) {
        this.reposts = reposts;
    }

    public ViewsById getViews() {
        return views;
    }

    public void setViews(ViewsById views) {
        this.views = views;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public List<CopyHistoryWalls> getCopyHistoryWalls() {
        return copyHistoryWalls;
    }

    public void setCopyHistoryWalls(List<CopyHistoryWalls> copyHistoryWalls) {
        this.copyHistoryWalls = copyHistoryWalls;
    }
}
