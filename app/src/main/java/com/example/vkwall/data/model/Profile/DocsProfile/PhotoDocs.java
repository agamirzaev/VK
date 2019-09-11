package com.example.vkwall.data.model.Profile.DocsProfile;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhotoDocs {
    @SerializedName("sizes")
    private List<SizeDocs> sizes;

    public List<SizeDocs> getSizes() {
        return sizes;
    }

    public void setSizes(List<SizeDocs> sizes) {
        this.sizes = sizes;
    }
}
