package com.example.vkwall.data.model.GetWallByID;

import com.google.gson.annotations.SerializedName;

public class ProfileById {
    @SerializedName("id")
    private Integer id;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("is_closed")
    private Boolean isClosed;
    @SerializedName("can_access_closed")
    private Boolean canAccessClosed;
    @SerializedName("sex")
    private Integer sex;
    @SerializedName("screen_name")
    private String screenName;
    @SerializedName("photo_50")
    private String photo50;
    @SerializedName("photo_100")
    private String photo100;
    @SerializedName("photo_max_orig")
    private String photo_max_orig;
    @SerializedName("online")
    private Integer online;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    public Boolean getCanAccessClosed() {
        return canAccessClosed;
    }

    public void setCanAccessClosed(Boolean canAccessClosed) {
        this.canAccessClosed = canAccessClosed;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getPhoto50() {
        return photo50;
    }

    public void setPhoto50(String photo50) {
        this.photo50 = photo50;
    }

    public String getPhoto100() {
        return photo100;
    }

    public void setPhoto100(String photo100) {
        this.photo100 = photo100;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public String getPhoto_max_orig() {
        return photo_max_orig;
    }

    public void setPhoto_max_orig(String photo_max_orig) {
        this.photo_max_orig = photo_max_orig;
    }
}
