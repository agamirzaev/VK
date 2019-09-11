package com.example.vkwall.mvp.usersinfo;

import com.example.vkwall.data.model.Profile.ProfileInfo.Response;
import com.example.vkwall.mvp.base.MvpView;



public interface ProfileInfoView extends MvpView {

    void showProfile(Response response);

    void showProgress();

    void hideProgress();

    void showNoInternet();


}
