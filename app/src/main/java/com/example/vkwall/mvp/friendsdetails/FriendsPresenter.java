package com.example.vkwall.mvp.friendsdetails;

import com.example.vkwall.data.DataManager;
import com.example.vkwall.data.model.FollowersList.FieldsFollowers;
import com.example.vkwall.data.model.FriendsInfo.FieldsFriendsInfo;
import com.example.vkwall.data.model.FriendsList.FieldsFriends;
import com.example.vkwall.data.model.Profile.AddFriends.FieldsAddFriends;
import com.example.vkwall.data.model.Profile.DeleteFriends.FieldsDelete;
import com.example.vkwall.data.model.ProfileWall.Wall.FieldsWall;
import com.example.vkwall.mvp.base.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FriendsPresenter extends BasePresenter<FriendsView.ViewFriends> implements FriendsView.PresenterFriends {
    private DataManager dataManager;

    private Call<FieldsFriendsInfo> infoCall;
    private Call<FieldsFriends> friendsCall;
    private Call<FieldsFollowers> followersCall;
    private Call<FieldsWall> wallCall;
    private Call<FieldsDelete> deleteCall;
    private Call<FieldsAddFriends> addFriendsCall;


    public FriendsPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(FriendsView.ViewFriends view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void addFriends(String user_id, String access_token, String v) {
        if (getView() != null) {
            getView().showProgress();
            addFriendsCall = dataManager.addFriends(user_id, access_token, v);
            addFriendsCall.enqueue(new Callback<FieldsAddFriends>() {
                @Override
                public void onResponse(Call<FieldsAddFriends> call, Response<FieldsAddFriends> response) {
                    if (getView() != null) {
                        getView().hideProgress();
                        if (response.isSuccessful()) {
                            getView().addFriends(response.body());
                        }
                    }
                }

                @Override
                public void onFailure(Call<FieldsAddFriends> call, Throwable t) {
                    if (getView() != null) {
                        getView().hideProgress();
                        getView().noInternet();
                    }
                }
            });
        }
    }

    @Override
    public void deleteFriends(String user_id, String access_token, String v) {
        if (getView() != null) {
            getView().showProgress();
            deleteCall = dataManager.deleteFriends(user_id, access_token, v);
            deleteCall.enqueue(new Callback<FieldsDelete>() {
                @Override
                public void onResponse(Call<FieldsDelete> call, Response<FieldsDelete> response) {
                    if (getView() != null) {
                        getView().hideProgress();
                        if (response.isSuccessful()) {
                            getView().deleteFriends(response.body().getResponse());
                        }
                    }
                }

                @Override
                public void onFailure(Call<FieldsDelete> call, Throwable t) {
                    if (getView() != null) {
                        getView().hideProgress();
                        getView().noInternet();
                    }
                }
            });
        }
    }

    @Override
    public void loadFriendsInfo(String user_ids, String access_token, String fields, String v) {
        if (getView() != null) {
            getView().showProgress();
            infoCall = dataManager.getFriendsInfo(user_ids, access_token, fields, v);
            infoCall.enqueue(new Callback<FieldsFriendsInfo>() {
                @Override
                public void onResponse(Call<FieldsFriendsInfo> call, Response<FieldsFriendsInfo> response) {
                    if (getView() != null) {
                        getView().hideProgress();
                        if (response.isSuccessful()) {
                            getView().showFriendsInfo(response.body().getResponse());
                        }
                    }
                }

                @Override
                public void onFailure(Call<FieldsFriendsInfo> call, Throwable t) {
                    if (getView() != null) {
                        getView().hideProgress();
                        getView().noInternet();
                    }
                }
            });
        }
    }

    @Override
    public void loadFriendsCount(String user_id, String access_token, String count, String fields, String v) {
        if (getView() != null) {
            getView().showProgress();
            friendsCall = dataManager.getFriendsCount(user_id, access_token, count, fields, v);
            friendsCall.enqueue(new Callback<FieldsFriends>() {
                @Override
                public void onResponse(Call<FieldsFriends> call, Response<FieldsFriends> response) {
                    if (getView() != null) {
                        getView().hideProgress();
                        if (response.isSuccessful()) {
                            getView().showFriendsCount(response.body().getResponse());
                        }
                    }
                }

                @Override
                public void onFailure(Call<FieldsFriends> call, Throwable t) {
                    if (getView() != null) {
                        getView().hideProgress();
                        getView().noInternet();
                    }
                }
            });
        }
    }

    @Override
    public void loadFollowers(String user_id, String access_token, String fields, String v) {
        if (getView() != null) {
            getView().showProgress();
            followersCall = dataManager.getFollowers(user_id, access_token, fields, v);
            followersCall.enqueue(new Callback<FieldsFollowers>() {
                @Override
                public void onResponse(Call<FieldsFollowers> call, Response<FieldsFollowers> response) {
                    if (getView() != null) {
                        getView().hideProgress();
                        if (response.isSuccessful()) {
                            getView().showFollowers(response.body().getResponse());
                        }
                    }
                }

                @Override
                public void onFailure(Call<FieldsFollowers> call, Throwable t) {
                    getView().hideProgress();
                    getView().noInternet();
                }
            });
        }
    }

    @Override
    public void loadWallFriends(String user_id, String access_token, int extended, String filter, String fields, String v) {
        if (getView() != null) {
            getView().showProgress();
            wallCall = dataManager.getWall(user_id, access_token, extended, filter, fields, v);
            wallCall.enqueue(new Callback<FieldsWall>() {
                @Override
                public void onResponse(Call<FieldsWall> call, Response<FieldsWall> response) {
                    if (getView() != null) {
                        getView().hideProgress();
                        if (response.isSuccessful()) {
                            getView().showWallFriends(
                                    response.body().getResponse().getItems(),
                                    response.body().getResponse().getProfiles(),
                                    response.body().getResponse().getGroups());
                        }
                    }
                }

                @Override
                public void onFailure(Call<FieldsWall> call, Throwable t) {
                    getView().hideProgress();
                    getView().noInternet();
                }
            });
        }
    }
}
