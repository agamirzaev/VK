package com.example.vkwall.data.model.Profile.FaveProfile;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostFave {
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
    private List<AttachmentFave> attachments;
    @SerializedName("post_source")
    private PostSourceFave postSource;
    @SerializedName("comments")
    private CommentsFave comments;
    @SerializedName("likes")
    private LikesFave likes;
    @SerializedName("reposts")
    private RepostsFave reposts;
    @SerializedName("views")
    private ViewsFave views;
    @SerializedName("is_favorite")
    private Boolean isFavorite;
    @SerializedName("marked_as_ads")
    private Integer markedAsAds;

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

    public List<AttachmentFave> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<AttachmentFave> attachments) {
        this.attachments = attachments;
    }

    public PostSourceFave getPostSource() {
        return postSource;
    }

    public void setPostSource(PostSourceFave postSource) {
        this.postSource = postSource;
    }

    public CommentsFave getComments() {
        return comments;
    }

    public void setComments(CommentsFave comments) {
        this.comments = comments;
    }

    public LikesFave getLikes() {
        return likes;
    }

    public void setLikes(LikesFave likes) {
        this.likes = likes;
    }

    public RepostsFave getReposts() {
        return reposts;
    }

    public void setReposts(RepostsFave reposts) {
        this.reposts = reposts;
    }

    public ViewsFave getViews() {
        return views;
    }

    public void setViews(ViewsFave views) {
        this.views = views;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public Integer getMarkedAsAds() {
        return markedAsAds;
    }

    public void setMarkedAsAds(Integer markedAsAds) {
        this.markedAsAds = markedAsAds;
    }

}
