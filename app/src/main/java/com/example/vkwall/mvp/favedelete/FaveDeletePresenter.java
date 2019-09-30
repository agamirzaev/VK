package com.example.vkwall.mvp.favedelete;


import android.util.Log;

import com.example.vkwall.data.DataManager;
import com.example.vkwall.data.model.AddFave.FieldsAdd;
import com.example.vkwall.data.model.DeleteFave.ResponseDeleteFave;
import com.example.vkwall.data.model.Profile.FaveProfile.FieldsFave;
import com.example.vkwall.mvp.base.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FaveDeletePresenter extends BasePresenter<FaveDeleteView> {

    private DataManager dataManager;
    private Call<ResponseDeleteFave> deleteFaveCall;
    private Call<FieldsAdd> addCall;

    public FaveDeletePresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(FaveDeleteView view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void delete(int owner_id, int id, String access_token, String v) {
        if (getView() != null) {
            deleteFaveCall = dataManager.getDelFave(owner_id, id, access_token, v);
            deleteFaveCall.enqueue(new Callback<ResponseDeleteFave>() {
                @Override
                public void onResponse(Call<ResponseDeleteFave> call, Response<ResponseDeleteFave> response) {
                    if (getView() != null) {
                        if (response.isSuccessful()) {
                            Log.e("SUCCESS", call.request() + "");
                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseDeleteFave> call, Throwable t) {
                    if (getView() != null) {

                    }
                }
            });
        }
    }

    public void addFavePost(int owner_id, int post_id, String access_token, String v) {
        if (getView() != null) {
            addCall = dataManager.setAddFavePost(owner_id, post_id, access_token, v);
            addCall.enqueue(new Callback<FieldsAdd>() {
                @Override
                public void onResponse(Call<FieldsAdd> call, Response<FieldsAdd> response) {
                    if (getView() != null) {
                        if (response.isSuccessful()) {
                            Log.e("SUCCESS_ADD", call.request().toString());
                        }
                    }
                }

                @Override
                public void onFailure(Call<FieldsAdd> call, Throwable t) {
                    if (getView() != null) {
                        Log.e("ERROR_ADD", t.getMessage());
                    }
                }
            });
        }
    }
}
