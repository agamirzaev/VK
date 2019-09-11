package com.example.vkwall.mvp.video;

import com.example.vkwall.data.model.Profile.VideoProfile.GroupVideo;
import com.example.vkwall.data.model.Profile.VideoProfile.ItemVideo;
import com.example.vkwall.data.model.Profile.VideoProfile.ProfileVideo;
import com.example.vkwall.mvp.base.MvpPresenter;
import com.example.vkwall.mvp.base.MvpView;

import java.util.List;

public interface VideoContract {
    interface ViewVideoProfile extends MvpView {
        void showVideoProfile(List<ItemVideo> itemVideo);

        void showProgressVideo();

        void hideProgressVideo();

        void noInternetVideo();
    }


    interface PresenterVideo extends MvpPresenter<VideoContract.ViewVideoProfile> {
        void loadVideoProfile(String access_token, int extended, String v);
    }
}
