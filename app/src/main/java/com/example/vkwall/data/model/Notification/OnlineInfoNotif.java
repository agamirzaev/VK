package com.example.vkwall.data.model.Notification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OnlineInfoNotif {
    @SerializedName("visible")
    @Expose
    private Boolean visible;
    @SerializedName("last_seen")
    @Expose
    private Integer lastSeen;
    @SerializedName("is_mobile")
    @Expose
    private Boolean isMobile;
    @SerializedName("app_id")
    @Expose
    private Integer appId;
    @SerializedName("is_online")
    @Expose
    private Boolean isOnline;

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Integer getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Integer lastSeen) {
        this.lastSeen = lastSeen;
    }

    public Boolean getIsMobile() {
        return isMobile;
    }

    public void setIsMobile(Boolean isMobile) {
        this.isMobile = isMobile;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Boolean getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Boolean isOnline) {
        this.isOnline = isOnline;
    }

}
