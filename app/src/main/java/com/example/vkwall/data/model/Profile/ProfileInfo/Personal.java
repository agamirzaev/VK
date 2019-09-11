package com.example.vkwall.data.model.Profile.ProfileInfo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Personal {
    @SerializedName("langs")
    private List<String> langs;
    @SerializedName("inspired_by")

    private String inspiredBy;
    @SerializedName("people_main")
    private Integer peopleMain;
    @SerializedName("life_main")
    private Integer lifeMain;
    @SerializedName("smoking")
    private Integer smoking;
    @SerializedName("alcohol")
    private Integer alcohol;
    @SerializedName("religion_id")
    private Integer religionId;

    public List<String> getLangs() {
        return langs;
    }

    public void setLangs(List<String> langs) {
        this.langs = langs;
    }

    public String getInspiredBy() {
        return inspiredBy;
    }

    public void setInspiredBy(String inspiredBy) {
        this.inspiredBy = inspiredBy;
    }

    public Integer getPeopleMain() {
        return peopleMain;
    }

    public void setPeopleMain(Integer peopleMain) {
        this.peopleMain = peopleMain;
    }

    public Integer getLifeMain() {
        return lifeMain;
    }

    public void setLifeMain(Integer lifeMain) {
        this.lifeMain = lifeMain;
    }

    public Integer getSmoking() {
        return smoking;
    }

    public void setSmoking(Integer smoking) {
        this.smoking = smoking;
    }

    public Integer getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Integer alcohol) {
        this.alcohol = alcohol;
    }

    public Integer getReligionId() {
        return religionId;
    }

    public void setReligionId(Integer religionId) {
        this.religionId = religionId;
    }
}
