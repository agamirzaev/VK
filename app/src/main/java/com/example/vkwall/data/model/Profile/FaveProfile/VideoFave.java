package com.example.vkwall.data.model.Profile.FaveProfile;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideoFave {
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
    private List<ImageFave> image;
    @SerializedName("is_favorite")
    private Boolean isFavorite;
    @SerializedName("first_frame")
    private List<FirstFrameFave> firstFrame;
    @SerializedName("access_key")
    private String accessKey;
    @SerializedName("files")
    private FilesFave files;
    @SerializedName("player")
    private String player;
    @SerializedName("can_add")
    private Integer canAdd;
    @SerializedName("track_code")
    private String trackCode;
    @SerializedName("type")
    private String type;

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

    public List<ImageFave> getImage() {
        return image;
    }

    public void setImage(List<ImageFave> image) {
        this.image = image;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public List<FirstFrameFave> getFirstFrame() {
        return firstFrame;
    }

    public void setFirstFrame(List<FirstFrameFave> firstFrame) {
        this.firstFrame = firstFrame;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public FilesFave getFiles() {
        return files;
    }

    public void setFiles(FilesFave files) {
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

    public String getTrackCode() {
        return trackCode;
    }

    public void setTrackCode(String trackCode) {
        this.trackCode = trackCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
