package com.example.vkwall.mvp.friendswall;

import android.util.Log;

import com.example.vkwall.data.DataManager;
import com.example.vkwall.data.model.GetWallByID.FieldsById;
import com.example.vkwall.data.model.LikeWalls.FieldsLike;
import com.example.vkwall.mvp.base.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FriendsWallPresenter extends BasePresenter<FriendsWallContract.ViewFriendsWall>
        implements FriendsWallContract.PresenterFriendsWall {
    private DataManager dataManager;

    private Call<FieldsById> byIdCall;

    public FriendsWallPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(FriendsWallContract.ViewFriendsWall view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void loadFriendsWall(String posts, int extended, String fields, String filter, String access_token, String v) {
        if (getView() != null) {
            getView().showProgress();
            byIdCall = dataManager.getWallId(posts, extended, fields, filter, access_token, v);
            byIdCall.enqueue(new Callback<FieldsById>() {
                @Override
                public void onResponse(Call<FieldsById> call, Response<FieldsById> response) {
                    if (getView() != null) {
                        getView().hideProgress();
                        if (response.isSuccessful()) {
                            getView().showFriendsWall(response.body().getResponse().getItems(),
                                    response.body().getResponse().getProfiles(),
                                    response.body().getResponse().getGroups());
                        }
                    }
                }

                @Override
                public void onFailure(Call<FieldsById> call, Throwable t) {
                    if (getView() != null) {
                        getView().hideProgress();
                        getView().noInternet();
                    }
                    Log.e("FSDFS", t.getMessage());
                }
            });
        }
    }
}
