package com.example.vkwall.mvp.main;

import com.example.vkwall.data.DataManager;
import com.example.vkwall.data.model.FriendsList.FieldsFriends;
import com.example.vkwall.mvp.base.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {
    private DataManager dataManager;

    private Call<FieldsFriends> listCall;

    public MainPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }


    @Override
    public void attachView(MainContract.View view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void loadFriends(String access_token, String fields, String v) {
        if (getView() != null) {
            getView().showProgress();
            listCall = dataManager.getFriends(access_token, fields, v);
            listCall.enqueue(new Callback<FieldsFriends>() {
                @Override
                public void onResponse(Call<FieldsFriends> call, Response<FieldsFriends> response) {
                    if (getView() != null) {
                        getView().hideProgress();
                        if (response.isSuccessful()) {
                            getView().showFriends(response.body().getResponse().getItems());
                        }
                    }
                }

                @Override
                public void onFailure(Call<FieldsFriends> call, Throwable t) {
                    if (getView() != null) {
                        getView().hideProgress();
                        getView().noInternet();
                    }
                }
            });
        }
    }

}
