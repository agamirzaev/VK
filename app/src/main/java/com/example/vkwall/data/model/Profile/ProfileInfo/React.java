package com.example.vkwall.data.model.Profile.ProfileInfo;

import com.google.gson.annotations.SerializedName;

public class React {
    @SerializedName("x")
    private Integer x;
    @SerializedName("y")
    private Integer y;
    @SerializedName("x2")
    private Integer x2;
    @SerializedName("y2")
    private Integer y2;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getX2() {
        return x2;
    }

    public void setX2(Integer x2) {
        this.x2 = x2;
    }

    public Integer getY2() {
        return y2;
    }

    public void setY2(Integer y2) {
        this.y2 = y2;
    }
}
