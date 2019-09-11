package com.example.vkwall.data

import com.example.vkwall.data.model.DeleteFave.ResponseDeleteFave
import com.example.vkwall.data.model.FollowersList.FieldsFollowers
import com.example.vkwall.data.model.FriendsList.FieldsFriends
import com.example.vkwall.data.model.FriendsInfo.FieldsFriendsInfo
import com.example.vkwall.data.model.GetWallByID.FieldsById
import com.example.vkwall.data.model.LikeWalls.FieldsLike
import com.example.vkwall.data.model.Notification.FieldsNotif
import com.example.vkwall.data.model.Profile.AddFriends.FieldsAddFriends
import com.example.vkwall.data.model.Profile.DeleteFriends.FieldsDelete
import com.example.vkwall.data.model.Profile.DocsProfile.FieldsDocs
import com.example.vkwall.data.model.Profile.FaveProfile.FieldsFave
import com.example.vkwall.data.model.Profile.GroupProfile.FieldsGroup
import com.example.vkwall.data.model.Profile.PhotosProfile.FieldsPhotos
import com.example.vkwall.data.model.Profile.ProfileInfo.FieldsProfile
import com.example.vkwall.data.model.Profile.VideoProfile.FieldsVideo
import com.example.vkwall.data.model.ProfileWall.FieldsWall
import com.example.vkwall.data.remote.ServicesGenerator
import com.example.vkwall.data.remote.VkApi

import retrofit2.Call


class DataManager {

    private val vkApi = ServicesGenerator.createService(VkApi::class.java)

    /**
     * @param user_id
     * @param access_token
     * @param v
     */
    fun addFriends(user_id: String, access_token: String, v: String): Call<FieldsAddFriends> {
        return vkApi.addFriends(user_id, access_token, v);
    }

    /**
     * @param user_id
     * @param access_token
     * @param v
     */
    fun deleteFriends(user_id: String, access_token: String, v: String): Call<FieldsDelete> {
        return vkApi.deleteFriends(user_id, access_token, v)
    }

    /**
     * @param access_token
     * @param fields
     * @param v
     * @return
     */
    fun getFriends(access_token: String, fields: String, v: String): Call<FieldsFriends> {
        return vkApi.getFriendsList(access_token, fields, v)
    }

    /**
     * @param user_id
     * @param access_token
     * @param count
     * @param fields
     * @param v
     * @return
     */
    fun getFriendsCount(user_id: String, access_token: String, count: String, fields: String, v: String): Call<FieldsFriends> {
        return vkApi.getFriendsListCount(user_id, access_token, count, fields, v)
    }

    /**
     * @param user_ids
     * @param access_token
     * @param fields
     * @param v
     * @return
     */
    fun getFriendsInfo(user_ids: String, access_token: String, fields: String, v: String): Call<FieldsFriendsInfo> {
        return vkApi.getFriendsInfo(user_ids, access_token, fields, v)
    }

    /**
     * @param user_id
     * @param access_token
     * @param fields
     * @param v
     * @return
     */
    fun getFollowers(user_id: String, access_token: String, fields: String, v: String): Call<FieldsFollowers> {
        return vkApi.getFollowers(user_id, access_token, fields, v)
    }

    /**
     * @param access_token
     * @param fields
     * @param v
     * @return
     */
    fun getFollowersProfile(access_token: String, fields: String, v: String): Call<FieldsFollowers> {
        return vkApi.getFollowersProfile(access_token, fields, v)
    }

    /**
     * @param user_id
     * @param access_token
     * @param extended
     * @param filter
     * @param fields
     * @param v
     * @return
     */
    fun getWall(user_id: String, access_token: String, extended: Int, filter: String, fields: String, v: String): Call<FieldsWall> {
        return vkApi.getWallProfile(user_id, access_token, extended, filter, fields, v)
    }

    /**
     * @param access_token
     * @param extended
     * @param filter
     * @param fields
     * @param v
     * @return
     */
    fun getWallProfile(access_token: String, extended: Int, filter: String, fields: String, v: String): Call<FieldsWall> {
        return vkApi.getWallProfile(access_token, extended, filter, fields, v)
    }

    /**
     * @param owner_id
     * @param id
     * @param access_token
     * @param v
     * @return
     */
    fun getDelFave(owner_id: Int, id: Int, access_token: String, v: String): Call<ResponseDeleteFave> {
        return vkApi.getDeleteFave(owner_id, id, access_token, v)
    }

    /**
     * @param posts
     * @param extended
     * @param fields
     * @param filter
     * @param access_token
     * @param v
     * @return
     */
    fun getWallId(posts: String, extended: Int, fields: String, filter: String, access_token: String, v: String): Call<FieldsById> {
        return vkApi.getApiWallByID(posts, extended, fields, filter, access_token, v)
    }

    /**
     * @param access_token
     * @param fields
     * @param v
     * @return
     */
    fun getProfileInfo(access_token: String, fields: String, v: String): Call<FieldsProfile> {
        return vkApi.getProfileInfo(access_token, fields, v)
    }

    /**
     * @param type
     * @param owner_id
     * @param item_id
     * @param access_token
     * @param v
     * @return
     */
    fun getLike(type: String, owner_id: String, item_id: String, access_token: String, v: String): Call<FieldsLike> {
        return vkApi.getApiLikeFriends(type, owner_id, item_id, access_token, v)
    }

    /**
     * @param type
     * @param owner_id
     * @param item_id
     * @param access_token
     * @param v
     * @return
     */
    fun deleteLike(type: String, owner_id: String, item_id: String, access_token: String, v: String): Call<FieldsLike> {
        return vkApi.deleteLike(type, owner_id, item_id, access_token, v)
    }

    /**
     * @param access_token
     * @param v
     * @return
     */
    fun getDocsProfile(access_token: String, v: String): Call<FieldsDocs> {
        return vkApi.getDocs(access_token, v)
    }

    /**
     * @param access_token
     * @param extended
     * @param v
     * @return
     */
    fun getGroupsProfile(access_token: String, extended: Int, v: String): Call<FieldsGroup> {
        return vkApi.getGroups(access_token, extended, v)
    }

    /**
     * @param access_token
     * @param extended
     * @param v
     * @return
     */
    fun getFaveProfile(access_token: String, extended: Int, fields: String, item_type: String, v: String): Call<FieldsFave> {
        return vkApi.getFave(access_token, extended, fields, item_type, v)
    }

    /**
     * @param access_token
     * @param extended
     * @param v
     * @return
     */
    fun getVideoProfile(access_token: String, extended: Int, v: String): Call<FieldsVideo> {
        return vkApi.getVideo(access_token, extended, v)
    }


    /**
     * @param access_token
     * @param filters
     * @param v
     * @return
     */
    fun getNotifications(access_token: String, filters: String, v: String): Call<FieldsNotif> {
        return vkApi.getNotifications(access_token, filters, v)
    }


    /**
     * @param access_token
     * @param album_id
     * @param v
     * @return
     */
    fun getPhotoProfile(access_token: String, album_id: String, rev: Int, v: String): Call<FieldsPhotos> {
        return vkApi.getPhotos(access_token, album_id, rev, v)
    }


}
