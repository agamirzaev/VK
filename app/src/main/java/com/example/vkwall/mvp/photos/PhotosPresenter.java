package com.example.vkwall.mvp.photos;

import android.util.Log;

import com.example.vkwall.data.DataManager;
import com.example.vkwall.data.model.Profile.PhotosProfile.FieldsPhotos;
import com.example.vkwall.mvp.base.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosPresenter extends BasePresenter<PhotosContract.ViewPhotosProfile>
        implements PhotosContract.PresenterPhotos {

    private DataManager dataManager;
    private Call<FieldsPhotos> photosCall;

    public PhotosPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(PhotosContract.ViewPhotosProfile view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void loadPhotosProfile(String access_token, String v) {
        if (getView() != null) {
            getView().showProgressPhotos();
            photosCall = dataManager.getPhotoProfile(access_token, v);
            photosCall.enqueue(new Callback<FieldsPhotos>() {
                @Override
                public void onResponse(Call<FieldsPhotos> call, Response<FieldsPhotos> response) {
                    if (getView() != null) {
                        getView().hideProgressPhotos();
                        if (response.isSuccessful()) {
                            Log.e("SUCCESS_PHOTOS", call.request() + "");
                            getView().showPhotosProfile(response.body().getResponse().getItems());
                        }
                    }
                }

                @Override
                public void onFailure(Call<FieldsPhotos> call, Throwable t) {
                    if (getView() != null) {
                        getView().hideProgressPhotos();
                        getView().noInternetPhotos();
                    }
                }
            });
        }
    }

    @Override
    public void loadPhotoSaved(String access_token, String album_id, String v) {
        if (getView() != null) {
            getView().showProgressPhotos();
            photosCall = dataManager.getPhotoSaved(access_token, album_id, v);
            photosCall.enqueue(new Callback<FieldsPhotos>() {
                @Override
                public void onResponse(Call<FieldsPhotos> call, Response<FieldsPhotos> response) {
                    if (getView() != null) {
                        getView().hideProgressPhotos();
                        if (response.isSuccessful()) {
                            getView().showPhotoSaved(response.body().getResponse().getItems());
                        }
                    }
                }

                @Override
                public void onFailure(Call<FieldsPhotos> call, Throwable t) {
                    if (getView() != null) {
                        getView().hideProgressPhotos();
                        getView().noInternetPhotos();
                    }
                }
            });
        }
    }
}
