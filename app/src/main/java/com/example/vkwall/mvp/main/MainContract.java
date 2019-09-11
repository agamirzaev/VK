package com.example.vkwall.mvp.main;

import com.example.vkwall.data.model.FriendsList.ItemFriends;
import com.example.vkwall.mvp.base.MvpPresenter;
import com.example.vkwall.mvp.base.MvpView;


import java.util.List;

public interface MainContract {
    interface View extends MvpView {
        void showFriends(List<ItemFriends> itemFriends);

        void showProgress();

        void hideProgress();

        void noInternet();
    }

    interface Presenter extends MvpPresenter<View> {
        void loadFriends(String access_token, String fields, String v);
    }
}
