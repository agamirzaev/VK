package com.example.vkwall.data.model.FriendsInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class School {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("country")
    @Expose
    private Integer country;
    @SerializedName("city")
    @Expose
    private Integer city;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("year_from")
    @Expose
    private Integer yearFrom;
    @SerializedName("year_to")
    @Expose
    private Integer yearTo;
    @SerializedName("year_graduated")
    @Expose
    private Integer yearGraduated;
    @SerializedName("class")
    @Expose
    private String _class;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(Integer yearFrom) {
        this.yearFrom = yearFrom;
    }

    public Integer getYearTo() {
        return yearTo;
    }

    public void setYearTo(Integer yearTo) {
        this.yearTo = yearTo;
    }

    public Integer getYearGraduated() {
        return yearGraduated;
    }

    public void setYearGraduated(Integer yearGraduated) {
        this.yearGraduated = yearGraduated;
    }

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }
}
