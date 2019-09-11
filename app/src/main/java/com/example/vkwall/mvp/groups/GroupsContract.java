package com.example.vkwall.mvp.groups;

import com.example.vkwall.data.model.Profile.GroupProfile.ItemGroup;
import com.example.vkwall.mvp.base.MvpPresenter;
import com.example.vkwall.mvp.base.MvpView;

import java.util.List;

public interface GroupsContract {
    interface ViewGroupsProfile extends MvpView {
        void showGroupsProfile(List<ItemGroup> itemGroup);

        void showProgressGroups();

        void hideProgressGroups();

        void noInternetGroups();
    }


    interface PresenterGroups extends MvpPresenter<GroupsContract.ViewGroupsProfile> {
        void loadGroupsProfile(String access_token, int extended, String v);
    }
}
