package com.example.vkwall.mvp.notifications;

import android.util.Log;

import com.example.vkwall.data.DataManager;
import com.example.vkwall.data.model.Notification.FieldsNotif;
import com.example.vkwall.mvp.base.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationsPresenter extends BasePresenter<NotificationsContract.ViewNotifications>
        implements NotificationsContract.PresenterNotifications {

    private DataManager dataManager;
    private Call<FieldsNotif> notifCall;

    public NotificationsPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(NotificationsContract.ViewNotifications view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void loadNotifications(String access_token, String filters, String v) {
        if (getView() != null) {
            getView().showProgressNotifications();
            notifCall = dataManager.getNotifications(access_token, filters, v);
            notifCall.enqueue(new Callback<FieldsNotif>() {
                @Override
                public void onResponse(Call<FieldsNotif> call, Response<FieldsNotif> response) {
                    if (getView() != null) {
                        getView().hideProgressNotifications();
                        if (response.isSuccessful()) {
                            Log.e("SUCCESS_NOTIFICATIONS", call.request() + "");
                            getView().showNotifications(
                                    response.body().getResponse().getItems(),
                                    response.body().getResponse().getProfiles());
                        }
                    }
                }

                @Override
                public void onFailure(Call<FieldsNotif> call, Throwable t) {
                    if (getView() != null) {
                        Log.e("ERROR_NOTIFICATIONS", t.getMessage());
                        getView().hideProgressNotifications();
                        getView().noInternetNotifications();
                    }
                }
            });
        }
    }
}
