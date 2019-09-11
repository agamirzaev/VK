package com.example.vkwall.mvp.fave;

import com.example.vkwall.data.model.Profile.FaveProfile.FieldsFave;
import com.example.vkwall.data.remote.ServicesGenerator;
import com.example.vkwall.data.remote.VkApi;
import com.example.vkwall.mvp.base.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavePresenter extends BasePresenter<FaveContract> {
    private VkApi vkApi = ServicesGenerator.INSTANCE.createService(VkApi.class);

    @Override
    public void attachView(FaveContract view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void loadFaveProfile(String access_token, int extended, String fields, String item_type, String v) {
        if (getView() != null) {
            getView().showProgressFave();
            vkApi.getFave(access_token, extended, fields, item_type, v).enqueue(new Callback<FieldsFave>() {
                @Override
                public void onResponse(Call<FieldsFave> call, Response<FieldsFave> response) {
                    if (getView() != null) {
                        getView().hideProgressFave();
                        if (response.isSuccessful()) {
                            getView().showFaveProfile(
                                    response.body().getResponse().getItems(),
                                    response.body().getResponse().getProfiles(),
                                    response.body().getResponse().getGroups()
                            );
                        }
                    }
                }

                @Override
                public void onFailure(Call<FieldsFave> call, Throwable t) {
                    if (getView() != null) {
                        getView().hideProgressFave();
                        getView().noInternetFave();
                    }
                }
            });
        }
    }
}
