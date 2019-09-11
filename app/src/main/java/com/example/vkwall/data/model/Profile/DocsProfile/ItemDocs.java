package com.example.vkwall.data.model.Profile.DocsProfile;

import com.google.gson.annotations.SerializedName;

public class ItemDocs {
    @SerializedName("id")
    private Integer id;
    @SerializedName("owner_id")
    private Integer ownerId;
    @SerializedName("title")
    private String title;
    @SerializedName("size")
    private Integer size;
    @SerializedName("ext")
    private String ext;
    @SerializedName("url")
    private String url;
    @SerializedName("date")
    private Integer date;
    @SerializedName("type")
    private Integer type;
    @SerializedName("preview")
    private PreviewDocs preview;

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

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public PreviewDocs getPreview() {
        return preview;
    }

    public void setPreview(PreviewDocs preview) {
        this.preview = preview;
    }
}
