package com.example.vkwall.data.model.Profile.PhotosProfile;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemPhotos {
    @SerializedName("id")
    private Integer id;
    @SerializedName("album_id")
    private Integer albumId;
    @SerializedName("owner_id")
    private Integer ownerId;
    @SerializedName("sizes")
    private List<SizePhotos> sizes;
    @SerializedName("text")
    private String text;
    @SerializedName("date")
    private Integer date;
    @SerializedName("post_id")
    private Integer postId;
    @SerializedName("likes")
    private LikesPhotos likes;
    @SerializedName("reposts")
    private RepostsPhotos reposts;
    @SerializedName("comments")
    private CommentsPhotos comments;
    @SerializedName("can_comment")
    private Integer canComment;
    @SerializedName("tags")
    private TagsPhotos tags;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<SizePhotos> getSizes() {
        return sizes;
    }

    public void setSizes(List<SizePhotos> sizes) {
        this.sizes = sizes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public LikesPhotos getLikes() {
        return likes;
    }

    public void setLikes(LikesPhotos likes) {
        this.likes = likes;
    }

    public RepostsPhotos getReposts() {
        return reposts;
    }

    public void setReposts(RepostsPhotos reposts) {
        this.reposts = reposts;
    }

    public CommentsPhotos getComments() {
        return comments;
    }

    public void setComments(CommentsPhotos comments) {
        this.comments = comments;
    }

    public Integer getCanComment() {
        return canComment;
    }

    public void setCanComment(Integer canComment) {
        this.canComment = canComment;
    }

    public TagsPhotos getTags() {
        return tags;
    }

    public void setTags(TagsPhotos tags) {
        this.tags = tags;
    }
}
