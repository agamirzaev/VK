package com.example.vkwall.data.model.Profile.ProfileInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {
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
    @Expose
    private Integer sex;
    @SerializedName("nickname")
    @Expose
    private String nickname;
    @SerializedName("domain")
    @Expose
    private String domain;
    @SerializedName("screen_name")
    @Expose
    private String screenName;
    @SerializedName("bdate")
    @Expose
    private String bdate;
    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("country")
    @Expose
    private Country country;
    @SerializedName("timezone")
    @Expose
    private Integer timezone;
    @SerializedName("photo_50")
    @Expose
    private String photo50;
    @SerializedName("photo_100")
    @Expose
    private String photo100;
    @SerializedName("photo_200")
    @Expose
    private String photo200;
    @SerializedName("photo_max")
    @Expose
    private String photoMax;
    @SerializedName("photo_200_orig")
    @Expose
    private String photo200Orig;
    @SerializedName("photo_400_orig")
    @Expose
    private String photo400Orig;
    @SerializedName("photo_max_orig")
    @Expose
    private String photoMaxOrig;
    @SerializedName("photo_id")
    @Expose
    private String photoId;
    @SerializedName("has_photo")
    @Expose
    private Integer hasPhoto;
    @SerializedName("has_mobile")
    @Expose
    private Integer hasMobile;
    @SerializedName("is_friend")
    @Expose
    private Integer isFriend;
    @SerializedName("friend_status")
    @Expose
    private Integer friendStatus;
    @SerializedName("online")
    @Expose
    private Integer online;
    @SerializedName("can_post")
    @Expose
    private Integer canPost;
    @SerializedName("can_see_all_posts")
    @Expose
    private Integer canSeeAllPosts;
    @SerializedName("can_see_audio")
    @Expose
    private Integer canSeeAudio;
    @SerializedName("can_write_private_message")
    @Expose
    private Integer canWritePrivateMessage;
    @SerializedName("can_send_friend_request")
    @Expose
    private Integer canSendFriendRequest;
    @SerializedName("mobile_phone")
    @Expose
    private String mobilePhone;
    @SerializedName("home_phone")
    @Expose
    private String homePhone;
    @SerializedName("site")
    @Expose
    private String site;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("last_seen")
    @Expose
    private LastSeen lastSeen;
    @SerializedName("crop_photo")
    @Expose
    private CropPhoto cropPhoto;
    @SerializedName("verified")
    @Expose
    private Integer verified;
    @SerializedName("can_be_invited_group")
    @Expose
    private Boolean canBeInvitedGroup;
    @SerializedName("followers_count")
    @Expose
    private Integer followersCount;
    @SerializedName("blacklisted")
    @Expose
    private Integer blacklisted;
    @SerializedName("blacklisted_by_me")
    @Expose
    private Integer blacklistedByMe;
    @SerializedName("is_favorite")
    @Expose
    private Integer isFavorite;
    @SerializedName("is_hidden_from_feed")
    @Expose
    private Integer isHiddenFromFeed;
    @SerializedName("common_count")
    @Expose
    private Integer commonCount;
    @SerializedName("career")
    @Expose
    private List<Career> career;
    @SerializedName("military")
    @Expose
    private List<Military> military ;
    @SerializedName("university")
    @Expose
    private Integer university;
    @SerializedName("university_name")
    @Expose
    private String universityName;
    @SerializedName("faculty")
    @Expose
    private Integer faculty;
    @SerializedName("faculty_name")
    @Expose
    private String facultyName;
    @SerializedName("graduation")
    @Expose
    private Integer graduation;
    @SerializedName("home_town")
    @Expose
    private String homeTown;
    @SerializedName("relation")
    @Expose
    private Integer relation;
    @SerializedName("personal")
    @Expose
    private Personal personal;
    @SerializedName("interests")
    @Expose
    private String interests;
    @SerializedName("music")
    @Expose
    private String music;
    @SerializedName("activities")
    @Expose
    private String activities;
    @SerializedName("movies")
    @Expose
    private String movies;
    @SerializedName("tv")
    @Expose
    private String tv;
    @SerializedName("books")
    @Expose
    private String books;
    @SerializedName("games")
    @Expose
    private String games;
    @SerializedName("universities")
    @Expose
    private List<Object> universities;
    @SerializedName("schools")
    @Expose
    private List<Object> schools;
    @SerializedName("about")
    @Expose
    private String about;
    @SerializedName("relatives")
    @Expose
    private List<Object> relatives ;
    @SerializedName("quotes")
    @Expose
    private String quotes;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
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

    public String getPhoto200() {
        return photo200;
    }

    public void setPhoto200(String photo200) {
        this.photo200 = photo200;
    }

    public String getPhotoMax() {
        return photoMax;
    }

    public void setPhotoMax(String photoMax) {
        this.photoMax = photoMax;
    }

    public String getPhoto200Orig() {
        return photo200Orig;
    }

    public void setPhoto200Orig(String photo200Orig) {
        this.photo200Orig = photo200Orig;
    }

    public String getPhoto400Orig() {
        return photo400Orig;
    }

    public void setPhoto400Orig(String photo400Orig) {
        this.photo400Orig = photo400Orig;
    }

    public String getPhotoMaxOrig() {
        return photoMaxOrig;
    }

    public void setPhotoMaxOrig(String photoMaxOrig) {
        this.photoMaxOrig = photoMaxOrig;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public Integer getHasPhoto() {
        return hasPhoto;
    }

    public void setHasPhoto(Integer hasPhoto) {
        this.hasPhoto = hasPhoto;
    }

    public Integer getHasMobile() {
        return hasMobile;
    }

    public void setHasMobile(Integer hasMobile) {
        this.hasMobile = hasMobile;
    }

    public Integer getIsFriend() {
        return isFriend;
    }

    public void setIsFriend(Integer isFriend) {
        this.isFriend = isFriend;
    }

    public Integer getFriendStatus() {
        return friendStatus;
    }

    public void setFriendStatus(Integer friendStatus) {
        this.friendStatus = friendStatus;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public Integer getCanPost() {
        return canPost;
    }

    public void setCanPost(Integer canPost) {
        this.canPost = canPost;
    }

    public Integer getCanSeeAllPosts() {
        return canSeeAllPosts;
    }

    public void setCanSeeAllPosts(Integer canSeeAllPosts) {
        this.canSeeAllPosts = canSeeAllPosts;
    }

    public Integer getCanSeeAudio() {
        return canSeeAudio;
    }

    public void setCanSeeAudio(Integer canSeeAudio) {
        this.canSeeAudio = canSeeAudio;
    }

    public Integer getCanWritePrivateMessage() {
        return canWritePrivateMessage;
    }

    public void setCanWritePrivateMessage(Integer canWritePrivateMessage) {
        this.canWritePrivateMessage = canWritePrivateMessage;
    }

    public Integer getCanSendFriendRequest() {
        return canSendFriendRequest;
    }

    public void setCanSendFriendRequest(Integer canSendFriendRequest) {
        this.canSendFriendRequest = canSendFriendRequest;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LastSeen getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(LastSeen lastSeen) {
        this.lastSeen = lastSeen;
    }

    public CropPhoto getCropPhoto() {
        return cropPhoto;
    }

    public void setCropPhoto(CropPhoto cropPhoto) {
        this.cropPhoto = cropPhoto;
    }

    public Integer getVerified() {
        return verified;
    }

    public void setVerified(Integer verified) {
        this.verified = verified;
    }

    public Boolean getCanBeInvitedGroup() {
        return canBeInvitedGroup;
    }

    public void setCanBeInvitedGroup(Boolean canBeInvitedGroup) {
        this.canBeInvitedGroup = canBeInvitedGroup;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    public Integer getBlacklisted() {
        return blacklisted;
    }

    public void setBlacklisted(Integer blacklisted) {
        this.blacklisted = blacklisted;
    }

    public Integer getBlacklistedByMe() {
        return blacklistedByMe;
    }

    public void setBlacklistedByMe(Integer blacklistedByMe) {
        this.blacklistedByMe = blacklistedByMe;
    }

    public Integer getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Integer isFavorite) {
        this.isFavorite = isFavorite;
    }

    public Integer getIsHiddenFromFeed() {
        return isHiddenFromFeed;
    }

    public void setIsHiddenFromFeed(Integer isHiddenFromFeed) {
        this.isHiddenFromFeed = isHiddenFromFeed;
    }

    public Integer getCommonCount() {
        return commonCount;
    }

    public void setCommonCount(Integer commonCount) {
        this.commonCount = commonCount;
    }

    public List<Career> getCareer() {
        return career;
    }

    public void setCareer(List<Career> career) {
        this.career = career;
    }

    public List<Military> getMilitary() {
        return military;
    }

    public void setMilitary(List<Military> military) {
        this.military = military;
    }

    public Integer getUniversity() {
        return university;
    }

    public void setUniversity(Integer university) {
        this.university = university;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public Integer getFaculty() {
        return faculty;
    }

    public void setFaculty(Integer faculty) {
        this.faculty = faculty;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public Integer getGraduation() {
        return graduation;
    }

    public void setGraduation(Integer graduation) {
        this.graduation = graduation;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public Integer getRelation() {
        return relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public String getMovies() {
        return movies;
    }

    public void setMovies(String movies) {
        this.movies = movies;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public String getBooks() {
        return books;
    }

    public void setBooks(String books) {
        this.books = books;
    }

    public String getGames() {
        return games;
    }

    public void setGames(String games) {
        this.games = games;
    }

    public List<Object> getUniversities() {
        return universities;
    }

    public void setUniversities(List<Object> universities) {
        this.universities = universities;
    }

    public List<Object> getSchools() {
        return schools;
    }

    public void setSchools(List<Object> schools) {
        this.schools = schools;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<Object> getRelatives() {
        return relatives;
    }

    public void setRelatives(List<Object> relatives) {
        this.relatives = relatives;
    }

    public String getQuotes() {
        return quotes;
    }

    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }

}
