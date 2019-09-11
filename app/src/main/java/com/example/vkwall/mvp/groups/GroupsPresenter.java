package com.example.vkwall.mvp.groups;

import android.util.Log;

import com.example.vkwall.data.DataManager;
import com.example.vkwall.data.model.Profile.GroupProfile.FieldsGroup;
import com.example.vkwall.mvp.base.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroupsPresenter extends BasePresenter<GroupsContract.ViewGroupsProfile>
        implements GroupsContract.PresenterGroups {
    private DataManager dataManager;
    private Call<FieldsGroup> groupCall;

    public GroupsPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(GroupsContract.ViewGroupsProfile view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void loadGroupsProfile(String access_token, int extended, String v) {
        if (getView() != null) {
            getView().showProgressGroups();
            groupCall = dataManager.getGroupsProfile(access_token, extended, v);
            groupCall.enqueue(new Callback<FieldsGroup>() {
                @Override
                public void onResponse(Call<FieldsGroup> call, Response<FieldsGroup> response) {
                    if (getView() != null) {
                        getView().hideProgressGroups();
                        if (response.isSuccessful()) {
                            Log.e("SUCCESS_GROUPS", call.request() + "");
                            getView().showGroupsProfile(response.body().getResponse().getItems());
                        }
                    }
                }

                @Override
                public void onFailure(Call<FieldsGroup> call, Throwable t) {
                    if (getView() != null) {
                        getView().hideProgressGroups();
                        getView().noInternetGroups();
                    }
                }
            });
        }
    }
}
