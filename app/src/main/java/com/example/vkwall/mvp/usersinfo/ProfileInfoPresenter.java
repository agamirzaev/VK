package com.example.vkwall.mvp.usersinfo;

import android.util.Log;

import com.example.vkwall.data.DataManager;
import com.example.vkwall.data.model.Profile.ProfileInfo.FieldsProfile;
import com.example.vkwall.mvp.base.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileInfoPresenter extends BasePresenter<ProfileInfoView> {
    private DataManager dataManager;

    private Call<FieldsProfile> profileCall;

    public ProfileInfoPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(ProfileInfoView view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void ProfileInfo(String access_token, String fields, String v) {
        if (getView() != null) {
            getView().showProgress();
            profileCall = dataManager.getProfileInfo(access_token, fields, v);
            profileCall.enqueue(new Callback<FieldsProfile>() {
                @Override
                public void onResponse(Call<FieldsProfile> call, Response<FieldsProfile> response) {
                    if (getView() != null) {
                        getView().hideProgress();
                        if (response.isSuccessful()) {
                            Log.e("ERROR", call.request() + "");
                            getView().showProfile(response.body().getResponse().get(0));
                        }
                    }
                }

                @Override
                public void onFailure(Call<FieldsProfile> call, Throwable t) {
                    if (getView() != null) {
                        Log.e("ERROR", t.getMessage());
                        getView().hideProgress();
                        getView().showNoInternet();
                    }
                }

            });
        }
    }
}
