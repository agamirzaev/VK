package com.example.vkwall.data.model.AddFave;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FieldsAdd {
    @SerializedName("response")
    @Expose
    private Integer response;

    public Integer getResponse() {
        return response;
    }

    public void setResponse(Integer response) {
        this.response = response;
    }
}
