package com.example.vkwall.data.remote

import com.example.vkwall.data.model.AddFave.FieldsAdd
import com.example.vkwall.data.model.DeleteFave.ResponseDeleteFave
import com.example.vkwall.data.model.DeleteWall.FieldsDeleteWall
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
import com.example.vkwall.data.model.Profile.ProfileStatus.FieldsGetStatus
import com.example.vkwall.data.model.Profile.ProfileStatus.FieldsSetStatus
import com.example.vkwall.data.model.Profile.VideoProfile.FieldsVideo
import com.example.vkwall.data.model.ProfileWall.Comments.Fields
import com.example.vkwall.data.model.ProfileWall.Wall.FieldsWall
import com.example.vkwall.data.model.Recommended.FieldsRecommended
import com.example.vkwall.data.model.Search.FieldsSearch

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface VkApi {

    @FormUrlEncoded
    @POST("wall.delete")
    fun deleteWall(
            @Field("owner_id") owner_id: Int,
            @Field("post_id") post_id: Int,
            @Field("access_token") access_token: String,
            @Field("v") v: String
    ): Call<FieldsDeleteWall>

    /**
     * @param access_token
     * @param v
     */
    @GET("newsfeed.getRecommended")
    fun newsfeedGetRecommended(
            @Query("access_token") access_token: String,
            @Query("v") v: String
    ): Call<FieldsRecommended>


    /**
     * @param q
     * @param fields
     * @param access_token
     * @param v
     */
    @GET("search.getHints")
    fun setSearch(
            @Query("q") search: String,
            @Query("fields") fields: String,
            @Query("limit") limit: Int,
            @Query("access_token") access_token: String,
            @Query("v") v: String
    ): Call<FieldsSearch>

    /**
     * @param text
     * @param access_token
     * @param v
     */
    @FormUrlEncoded
    @POST("status.set")
    fun setStatus(
            @Field("text") text: String,
            @Field("access_token") access_token: String,
            @Field("v") v: String
    ): Call<FieldsSetStatus>


    /**
     * @param owner_id
     * @param posts_id
     * @param access_token
     * @param v
     */
    @FormUrlEncoded
    @POST("fave.addPost")
    fun faveAddPost(
            @Field("owner_id") owner_id: Int,
            @Field("id") posts_id: Int,
            @Field("access_token") access_token: String,
            @Field("v") v: String
    ): Call<FieldsAdd>


    /**
     * @param access_token
     * @param v
     */
    @GET("status.get")
    fun getStatus(
            @Query("access_token") access_token: String,
            @Query("v") v: String
    ): Call<FieldsGetStatus>

    /**
     * GET запрос - список моих друзей
     *
     * @param access_token
     * @param fields
     * @param v
     * @return
     */
    @GET("friends.get")
    fun getFriendsList(
            @Query("access_token") access_token: String,
            @Query("fields") fields: String,
            @Query("v") v: String
    ): Call<FieldsFriends>


    /**
     *
     */
    @FormUrlEncoded
    @POST("friends.delete")
    fun deleteFriends(
            @Field("user_id") user_ids: String,
            @Field("access_token") access_token: String,
            @Field("v") v: String
    ): Call<FieldsDelete>

    /**
     *
     */
    @FormUrlEncoded
    @POST("friends.add")
    fun addFriends(
            @Field("user_id") user_ids: String,
            @Field("access_token") access_token: String,
            @Field("v") v: String
    ): Call<FieldsAddFriends>

    /**
     * GET запрос - вывод количество друзей пользователя
     *
     * @param user_id
     * @param access_token
     * @param count
     * @param fields
     * @param v
     * @return
     */
    @GET("friends.get")
    fun getFriendsListCount(
            @Query("user_id") user_id: String,
            @Query("access_token") access_token: String,
            @Query("count") count: String,
            @Query("fields") fields: String,
            @Query("v") v: String
    ): Call<FieldsFriends>

    /**
     * GET запрос - вывод информации пользователя (Друзей)
     *
     * @param user_ids
     * @param access_token
     * @param fields
     * @param v
     * @return
     */
    @GET("users.get")
    fun getFriendsInfo(
            @Query("user_ids") user_ids: String,
            @Query("access_token") access_token: String,
            @Query("fields") fields: String,
            @Query("v") v: String
    ): Call<FieldsFriendsInfo>

    /**
     * GET запрос - вывод моей информации
     *
     * @param access_token
     * @param fields
     * @param v
     * @return
     */
    @GET("users.get")
    fun getProfileInfo(
            @Query("access_token") access_token: String,
            @Query("fields") fields: String,
            @Query("v") v: String
    ): Call<FieldsProfile>

    /**
     * GET запрос - вывод количество подписчиков пользователя
     *
     * @param user_ids
     * @param access_token
     * @param fields
     * @param v
     * @return
     */
    @GET("users.getFollowers")
    fun getFollowers(
            @Query("user_id") user_ids: String,
            @Query("access_token") access_token: String,
            @Query("fields") fields: String,
            @Query("v") v: String
    ): Call<FieldsFollowers>

    /**
     * GET запрос - вывод количество подписчиков пользователя
     *
     * @param access_token
     * @param fields
     * @param v
     * @return
     */
    @GET("users.getFollowers")
    fun getFollowersProfile(
            @Query("access_token") access_token: String,
            @Query("fields") fields: String,
            @Query("v") v: String
    ): Call<FieldsFollowers>

    /**
     * GET запрос - вывод записей на стене пользователей
     *
     * @param access_token
     * @param extended
     * @param filter
     * @param fields
     * @param v
     * @return
     */
    @GET("wall.get")
    fun getWallProfile(
            @Query("access_token") access_token: String,
            @Query("extended") extended: Int,
            @Query("filter") filter: String,
            @Query("fields") fields: String,
            @Query("v") v: String
    ): Call<FieldsWall>


    /**
     * GET запрос - вывод записей на стене пользователей (Друзей)
     *
     * @param user_ids
     * @param access_token
     * @param extended
     * @param filter
     * @param fields
     * @param v
     * @return
     */
    @GET("wall.get")
    fun getWallProfile(
            @Query("owner_id") user_ids: String,
            @Query("access_token") access_token: String,
            @Query("extended") extended: Int,
            @Query("filter") filter: String,
            @Query("fields") fields: String,
            @Query("v") v: String
    ): Call<FieldsWall>


    /**
     * GET запрос - вывод одной записи на стене пользователей (Друзей)
     *
     * @param posts
     * @param extended
     * @param fields
     * @param filter
     * @param access_token
     * @param v
     * @return
     */
    @GET("wall.getById")
    fun getApiWallByID(
            @Query("posts") posts: String,
            @Query("extended") extended: Int,
            @Query("fields") fields: String,
            @Query("filter") filter: String,
            @Query("access_token") access_token: String,
            @Query("v") v: String
    ): Call<FieldsById>

    /**
     * GET запрос - вывод документов
     *
     * @param access_token
     * @param v
     * @return
     */
    @GET("docs.get")
    fun getDocs(
            @Query("access_token") access_token: String,
            @Query("v") v: String
    ): Call<FieldsDocs>

    /**
     * @param access_token
     * @param extended
     * @param v
     * @return
     */
    @GET("groups.get")
    fun getGroups(
            @Query("access_token") access_token: String,
            @Query("extended") extended: Int,
            @Query("v") v: String
    ): Call<FieldsGroup>

    /**
     * @param access_token
     * @param album_id
     * @param v
     * @return
     */
    @GET("photos.getAll")
    fun getPhotos(
            @Query("access_token") access_token: String,
            @Query("v") v: String
    ): Call<FieldsPhotos>


    /**
     * @param access_token
     * @param album_id
     * @param v
     * @return
     */
    @GET("photos.get")
    fun getPhotosSaved(
            @Query("access_token") access_token: String,
            @Query("album_id") album_id: String,
            @Query("v") v: String
    ): Call<FieldsPhotos>


    /**
     * @param access_token
     * @param extended
     * @param v
     * @return
     */
    @GET("video.get")
    fun getVideo(
            @Query("access_token") access_token: String,
            @Query("extended") extended: Int,
            @Query("v") v: String
    ): Call<FieldsVideo>

    /**
     * @param access_token
     * @param extended
     * @param v
     * @return
     */
    @GET("fave.get")
    fun getFave(
            @Query("access_token") access_token: String,
            @Query("extended") extended: Int,
            @Query("fields") fields: String,
            @Query("item_type") item_type: String,
            @Query("v") v: String
    ): Call<FieldsFave>

    /**
     * @param access_token
     * @param filters
     * @param v
     * @return
     */
    @GET("notifications.get")
    fun getNotifications(
            @Query("access_token") access_token: String,
            @Query("filters") filters: String,
            @Query("v") v: String
    ): Call<FieldsNotif>

    /**
     * POST запрос - добавление лайков
     *
     * @param type
     * @param owner_id
     * @param item_id
     * @param access_token
     * @param v
     * @return
     */
    @FormUrlEncoded
    @POST("likes.add")
    fun getApiLikeFriends(
            @Field("type") type: String,
            @Field("owner_id") owner_id: Int,
            @Field("item_id") item_id: Int,
            @Field("access_token") access_token: String,
            @Field("v") v: String
    ): Call<FieldsLike>


    /**
     * POST запрос - Удаление лайков
     *
     * @param type
     * @param owner_id
     * @param item_id
     * @param access_token
     * @param v
     * @return
     */
    @FormUrlEncoded
    @POST("likes.delete")
    fun deleteLike(
            @Field("type") type: String,
            @Field("owner_id") owner_id: Int,
            @Field("item_id") item_id: Int,
            @Field("access_token") access_token: String,
            @Field("v") v: String
    ): Call<FieldsLike>


    /**
     * @param owner_id
     * @param id
     * @param access_token
     * @param v
     * @return
     */
    @FormUrlEncoded
    @POST("fave.removePost")
    fun getDeleteFave(
            @Field("owner_id") owner_id: Int,
            @Field("id") id: Int,
            @Field("access_token") access_token: String,
            @Field("v") v: String
    ): Call<ResponseDeleteFave>


    /**
     * @param owner_id
     * @param post_id
     * @param extended
     * @param count
     * @param access_token
     * @param v
     * @return
     */
    @GET("wall.getComments")
    fun getCommentsWall(
            @Query("owner_id") owner_id: String,
            @Query("post_id") post_id: String,
            @Query("extended") extended: Int,
            @Query("count") count: Int,
            @Query("access_token") access_token: String,
            @Query("v") v: String
    ): Call<Fields>

}

