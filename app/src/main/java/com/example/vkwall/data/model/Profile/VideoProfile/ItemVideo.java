package com.example.vkwall.data.model.Profile.VideoProfile;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemVideo {
    @SerializedName("id")
    private Integer id;
    @SerializedName("owner_id")
    private Integer ownerId;
    @SerializedName("title")
    private String title;
    @SerializedName("duration")
    private Integer duration;
    @SerializedName("description")
    private String description;
    @SerializedName("date")
    private Integer date;
    @SerializedName("comments")
    private Integer comments;
    @SerializedName("views")
    private Integer views;
    @SerializedName("width")
    private Integer width;
    @SerializedName("height")
    private Integer height;
    @SerializedName("image")
    private List<ImageVideo> image;
    @SerializedName("is_favorite")
    private Boolean isFavorite;
    @SerializedName("first_frame")
    private List<FirstFrameVideo> firstFrame;
    @SerializedName("adding_date")
    private Integer addingDate;
    @SerializedName("files")
    private FilesVideo files;
    @SerializedName("player")
    private String player;
    @SerializedName("can_add")
    private Integer canAdd;
    @SerializedName("can_comment")
    private Integer canComment;
    @SerializedName("can_repost")
    private Integer canRepost;
    @SerializedName("can_like")
    private Integer canLike;
    @SerializedName("can_add_to_faves")
    private Integer canAddToFaves;
    @SerializedName("likes")
    private LikesVideo likes;
    @SerializedName("reposts")
    private RepostsVideo reposts;
    @SerializedName("type")
    private String type;
    @SerializedName("can_edit")
    private Integer canEdit;
    @SerializedName("privacy_view")
    private PrivacyViewVideo privacyView;
    @SerializedName("privacy_comment")
    private PrivacyCommentVideo privacyComment;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public List<ImageVideo> getImage() {
        return image;
    }

    public void setImage(List<ImageVideo> image) {
        this.image = image;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public List<FirstFrameVideo> getFirstFrame() {
        return firstFrame;
    }

    public void setFirstFrame(List<FirstFrameVideo> firstFrame) {
        this.firstFrame = firstFrame;
    }

    public Integer getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(Integer addingDate) {
        this.addingDate = addingDate;
    }

    public FilesVideo getFiles() {
        return files;
    }

    public void setFiles(FilesVideo files) {
        this.files = files;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Integer getCanAdd() {
        return canAdd;
    }

    public void setCanAdd(Integer canAdd) {
        this.canAdd = canAdd;
    }

    public Integer getCanComment() {
        return canComment;
    }

    public void setCanComment(Integer canComment) {
        this.canComment = canComment;
    }

    public Integer getCanRepost() {
        return canRepost;
    }

    public void setCanRepost(Integer canRepost) {
        this.canRepost = canRepost;
    }

    public Integer getCanLike() {
        return canLike;
    }

    public void setCanLike(Integer canLike) {
        this.canLike = canLike;
    }

    public Integer getCanAddToFaves() {
        return canAddToFaves;
    }

    public void setCanAddToFaves(Integer canAddToFaves) {
        this.canAddToFaves = canAddToFaves;
    }

    public LikesVideo getLikes() {
        return likes;
    }

    public void setLikes(LikesVideo likes) {
        this.likes = likes;
    }

    public RepostsVideo getReposts() {
        return reposts;
    }

    public void setReposts(RepostsVideo reposts) {
        this.reposts = reposts;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCanEdit() {
        return canEdit;
    }

    public void setCanEdit(Integer canEdit) {
        this.canEdit = canEdit;
    }

    public PrivacyViewVideo getPrivacyView() {
        return privacyView;
    }

    public void setPrivacyView(PrivacyViewVideo privacyView) {
        this.privacyView = privacyView;
    }

    public PrivacyCommentVideo getPrivacyComment() {
        return privacyComment;
    }

    public void setPrivacyComment(PrivacyCommentVideo privacyComment) {
        this.privacyComment = privacyComment;
    }
}
