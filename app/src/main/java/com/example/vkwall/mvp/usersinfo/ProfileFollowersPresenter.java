package com.example.vkwall.mvp.usersinfo;

import com.example.vkwall.data.DataManager;
import com.example.vkwall.data.model.FollowersList.FieldsFollowers;
import com.example.vkwall.data.model.ProfileWall.Wall.FieldsWall;
import com.example.vkwall.mvp.base.BasePresenter;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFollowersPresenter extends BasePresenter<ProfileFollowersView> {

    private DataManager dataManager;

    private Call<FieldsFollowers> followersCall;
    private Call<FieldsWall> wallCall;

    public ProfileFollowersPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(ProfileFollowersView view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void showFollowersProfile(String access_token, String fields, String v) {
        if (getView() != null) {
            getView().showProgress();
            followersCall = dataManager.getFollowersProfile(access_token, fields, v);
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
                    if (getView() != null) {
                        getView().hideProgress();
                        getView().showNoInternet();
                    }
                }
            });
        }
    }

    public void showWallProfile(String access_token, int extended, String filter, String fields, String v) {
        if (getView() != null) {
            getView().showProgress();
            wallCall = dataManager.getWallProfile(access_token, extended, filter, fields, v);
            wallCall.enqueue(new Callback<FieldsWall>() {
                @Override
                public void onResponse(Call<FieldsWall> call, Response<FieldsWall> response) {
                    if (getView() != null) {
                        getView().hideProgress();
                        if (response.isSuccessful()) {
                            getView().showWallProfile(response.body().getResponse().getItems(),
                                    response.body().getResponse().getProfiles(),
                                    response.body().getResponse().getGroups());
                        }
                    }
                }

                @Override
                public void onFailure(Call<FieldsWall> call, Throwable t) {
                    if (getView() != null) {
                        getView().hideProgress();
                        getView().showNoInternet();
                    }
                }
            });
        }
    }
}
