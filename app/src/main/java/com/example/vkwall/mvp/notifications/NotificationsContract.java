package com.example.vkwall.mvp.notifications;

import com.example.vkwall.data.model.Notification.ItemNotif;

import com.example.vkwall.data.model.Notification.ProfileNotif;
import com.example.vkwall.mvp.base.MvpPresenter;
import com.example.vkwall.mvp.base.MvpView;

import java.util.List;

public interface NotificationsContract {
    interface ViewNotifications extends MvpView {
        void showNotifications(List<ItemNotif> itemNotifs, List<ProfileNotif>profileNotifs);

        void showProgressNotifications();

        void hideProgressNotifications();

        void noInternetNotifications();
    }


    interface PresenterNotifications extends MvpPresenter<NotificationsContract.ViewNotifications> {
        void loadNotifications(String access_token, String filters, String v);
    }
}
