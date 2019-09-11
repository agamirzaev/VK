package com.example.vkwall.mvp.docs;

import com.example.vkwall.data.DataManager;
import com.example.vkwall.data.model.Profile.DocsProfile.FieldsDocs;
import com.example.vkwall.mvp.base.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DocsPresenter extends BasePresenter<DocsContract.ViewDocsProfile> implements DocsContract.PresenterDocs {
    private DataManager dataManager;
    private Call<FieldsDocs> docsCall;

    public DocsPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(DocsContract.ViewDocsProfile view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void loadDocsProfile(String access_token, String v) {
        if (getView() != null) {
            getView().showProgressDocs();
            docsCall = dataManager.getDocsProfile(access_token, v);
            docsCall.enqueue(new Callback<FieldsDocs>() {
                @Override
                public void onResponse(Call<FieldsDocs> call, Response<FieldsDocs> response) {
                    if (getView() != null) {
                        getView().hideProgressDocs();
                        if (response.isSuccessful()) {
                            getView().showDocsProfile(response.body().getResponse().getItems());
                        }
                    }
                }

                @Override
                public void onFailure(Call<FieldsDocs> call, Throwable t) {
                    getView().hideProgressDocs();
                    getView().noInternetDocs();
                }
            });
        }
    }
}
