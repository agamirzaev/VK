package com.example.vkwall.data.model.Profile.DocsProfile;

import com.google.gson.annotations.SerializedName;

public class PreviewDocs {
    @SerializedName("photo")
    private PhotoDocs photo;

    public PhotoDocs getPhoto() {
        return photo;
    }

    public void setPhoto(PhotoDocs photo) {
        this.photo = photo;
    }
}
