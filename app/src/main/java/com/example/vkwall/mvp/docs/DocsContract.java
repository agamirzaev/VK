package com.example.vkwall.mvp.docs;

import com.example.vkwall.data.model.Profile.DocsProfile.ItemDocs;
import com.example.vkwall.data.model.Profile.GroupProfile.ItemGroup;
import com.example.vkwall.mvp.base.MvpPresenter;
import com.example.vkwall.mvp.base.MvpView;

import java.util.List;

public interface DocsContract {
    interface ViewDocsProfile extends MvpView {
        void showDocsProfile(List<ItemDocs> itemDocs);

        void showProgressDocs();

        void hideProgressDocs();

        void noInternetDocs();
    }

    interface PresenterDocs extends MvpPresenter<ViewDocsProfile> {
        void loadDocsProfile(String access_token, String v);
    }
}
