package com.example.vkwall.data.model.Profile.ProfileInfo;

import com.google.gson.annotations.SerializedName;

public class Crop {
    @SerializedName("x")
    private Double x;
    @SerializedName("y")
    private Double y;
    @SerializedName("x2")
    private Double x2;
    @SerializedName("y2")
    private Double y2;

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getX2() {
        return x2;
    }

    public void setX2(Double x2) {
        this.x2 = x2;
    }

    public Double getY2() {
        return y2;
    }

    public void setY2(Double y2) {
        this.y2 = y2;
    }

}
