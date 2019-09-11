package com.example.vkwall.data.model.Notification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ParentNotif {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("from_id")
    @Expose
    private Integer fromId;
    @SerializedName("to_id")
    @Expose
    private Integer toId;
    @SerializedName("date")
    @Expose
    private Integer date;
    @SerializedName("post_type")
    @Expose
    private String postType;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("can_delete")
    @Expose
    private Integer canDelete;
    @SerializedName("can_archive")
    @Expose
    private Boolean canArchive;
    @SerializedName("is_archived")
    @Expose
    private Boolean isArchived;
    @SerializedName("attachments")
    @Expose
    private List<AttachmentNotif> attachments = null;
    @SerializedName("post_source")
    @Expose
    private PostSource postSource;
    @SerializedName("comments")
    @Expose
    private CommentsNotif comments;
    @SerializedName("likes")
    @Expose
    private LikesNotif likes;
    @SerializedName("is_favorite")
    @Expose
    private Boolean isFavorite;
    @SerializedName("album_id")
    @Expose
    private Integer albumId;
    @SerializedName("owner_id")
    @Expose
    private Integer ownerId;
    @SerializedName("sizes")
    @Expose
    private List<SizeFeedback> sizes;
    @SerializedName("post_id")
    @Expose
    private Integer postId;
    @SerializedName("access_key")
    @Expose
    private String accessKey;
    @SerializedName("can_comment")
    @Expose
    private Integer canComment;

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

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
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

    public List<AttachmentNotif> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<AttachmentNotif> attachments) {
        this.attachments = attachments;
    }

    public PostSource getPostSource() {
        return postSource;
    }

    public void setPostSource(PostSource postSource) {
        this.postSource = postSource;
    }

    public CommentsNotif getComments() {
        return comments;
    }

    public void setComments(CommentsNotif comments) {
        this.comments = comments;
    }

    public LikesNotif getLikes() {
        return likes;
    }

    public void setLikes(LikesNotif likes) {
        this.likes = likes;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public List<SizeFeedback> getSizes() {
        return sizes;
    }

    public void setSizes(List<SizeFeedback> sizes) {
        this.sizes = sizes;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public Integer getCanComment() {
        return canComment;
    }

    public void setCanComment(Integer canComment) {
        this.canComment = canComment;
    }
}
