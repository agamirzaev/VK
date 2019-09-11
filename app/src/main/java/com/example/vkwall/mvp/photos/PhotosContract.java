package com.example.vkwall.mvp.photos;

import com.example.vkwall.data.model.Profile.PhotosProfile.ItemPhotos;
import com.example.vkwall.mvp.base.MvpPresenter;
import com.example.vkwall.mvp.base.MvpView;

import java.util.List;

public interface PhotosContract {
    interface ViewPhotosProfile extends MvpView {
        void showPhotosProfile(List<ItemPhotos> itemPhotos);

        void showProgressPhotos();

        void hideProgressPhotos();

        void noInternetPhotos();
    }


    interface PresenterPhotos extends MvpPresenter<PhotosContract.ViewPhotosProfile> {
        void loadPhotosProfile(String access_token, String album_id, int rev, String v);
    }
}
