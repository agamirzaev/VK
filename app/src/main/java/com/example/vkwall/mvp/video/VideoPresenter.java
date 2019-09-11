package com.example.vkwall.mvp.video;

import android.util.Log;

import com.example.vkwall.data.DataManager;
import com.example.vkwall.data.model.Profile.VideoProfile.FieldsVideo;
import com.example.vkwall.mvp.base.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoPresenter extends BasePresenter<VideoContract.ViewVideoProfile> implements VideoContract.PresenterVideo {

    private DataManager dataManager;
    private Call<FieldsVideo> videoCall;

    public VideoPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(VideoContract.ViewVideoProfile view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void loadVideoProfile(String access_token, int extended, String v) {
        if (getView() != null) {
            getView().showProgressVideo();
            videoCall = dataManager.getVideoProfile(access_token, extended, v);
            videoCall.enqueue(new Callback<FieldsVideo>() {
                @Override
                public void onResponse(Call<FieldsVideo> call, Response<FieldsVideo> response) {
                    if (getView() != null) {
                        getView().hideProgressVideo();
                        if (response.isSuccessful()) {
                            Log.e("SUCCESS_VIDEO", call.request() + "");
                            getView().showVideoProfile(response.body().getResponse().getItems());
                        }
                    }
                }

                @Override
                public void onFailure(Call<FieldsVideo> call, Throwable t) {
                    if (getView() != null) {
                        getView().hideProgressVideo();
                        getView().noInternetVideo();
                    }
                }
            });
        }
    }
}
