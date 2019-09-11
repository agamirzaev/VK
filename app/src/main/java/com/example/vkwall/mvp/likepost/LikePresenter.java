package com.example.vkwall.mvp.likepost;


import com.example.vkwall.data.DataManager;
import com.example.vkwall.data.model.LikeWalls.FieldsLike;
import com.example.vkwall.mvp.base.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LikePresenter extends BasePresenter<LikeContract.ViewLikePost> implements LikeContract.PresenterLikePost {
    private DataManager dataManager;

    private Call<FieldsLike> likeCall;

    public LikePresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(LikeContract.ViewLikePost view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void likePostWall(String type, String owner_id, String item_id, String access_token, String v) {
        if (getView() != null) {
            likeCall = dataManager.getLike(type, owner_id, item_id, access_token, v);
            likeCall.enqueue(new Callback<FieldsLike>() {
                @Override
                public void onResponse(Call<FieldsLike> call, Response<FieldsLike> response) {
                    if (getView() != null) {
                        if (response.isSuccessful()) {
                            getView().showLike(response.body().getResponse());
                        }
                    }
                }

                @Override
                public void onFailure(Call<FieldsLike> call, Throwable t) {
                    if (getView() != null) {

                    }
                }
            });
        }
    }

    @Override
    public void deleteLike(String type, String owner_id, String item_id, String access_token, String v) {
        if (getView() != null) {
            likeCall = dataManager.deleteLike(type, owner_id, item_id, access_token, v);
            likeCall.enqueue(new Callback<FieldsLike>() {
                @Override
                public void onResponse(Call<FieldsLike> call, Response<FieldsLike> response) {
                    if (getView() != null) {
                        if (response.isSuccessful()) {
                            getView().deleteLike(response.body().getResponse());
                        }
                    }
                }

                @Override
                public void onFailure(Call<FieldsLike> call, Throwable t) {
                    if (getView() != null) {
                    }
                }
            });
        }
    }
}
