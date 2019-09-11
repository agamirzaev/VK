package com.example.vkwall.data.model.Notification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileNotif {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("is_closed")
    @Expose
    private Boolean isClosed;
    @SerializedName("can_access_closed")
    @Expose
    private Boolean canAccessClosed;
    @SerializedName("sex")
    @Expose
    private Integer sex;
    @SerializedName("screen_name")
    @Expose
    private String screenName;
    @SerializedName("photo_50")
    @Expose
    private String photo50;
    @SerializedName("photo_100")
    @Expose
    private String photo100;
    @SerializedName("online")
    @Expose
    private Integer online;
    @SerializedName("online_info")
    @Expose
    private OnlineInfoNotif onlineInfo;
    @SerializedName("deactivated")
    @Expose
    private String deactivated;
    @SerializedName("online_app")
    @Expose
    private Integer onlineApp;
    @SerializedName("online_mobile")
    @Expose
    private Integer onlineMobile;

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

    public OnlineInfoNotif getOnlineInfo() {
        return onlineInfo;
    }

    public void setOnlineInfo(OnlineInfoNotif onlineInfo) {
        this.onlineInfo = onlineInfo;
    }

    public String getDeactivated() {
        return deactivated;
    }

    public void setDeactivated(String deactivated) {
        this.deactivated = deactivated;
    }

    public Integer getOnlineApp() {
        return onlineApp;
    }

    public void setOnlineApp(Integer onlineApp) {
        this.onlineApp = onlineApp;
    }

    public Integer getOnlineMobile() {
        return onlineMobile;
    }

    public void setOnlineMobile(Integer onlineMobile) {
        this.onlineMobile = onlineMobile;
    }

}
