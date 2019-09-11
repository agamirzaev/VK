package com.example.vkwall.data.model.Profile.FaveProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhotoPreview {

    @SerializedName("sizes")
    @Expose
    private List<SizePreview> sizes;

    public List<SizePreview> getSizes() {
        return sizes;
    }

    public void setSizes(List<SizePreview> sizes) {
        this.sizes = sizes;
    }

}
