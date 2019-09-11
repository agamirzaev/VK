package com.example.vkwall.mvp.base;

public class BasePresenter<T extends MvpView> implements MvpPresenter<T> {
    private T mvpView;

    @Override
    public void attachView(T view) {
        mvpView = view;
    }

    @Override
    public void detachView() {
        mvpView = null;
    }

    public T getView() {
        return mvpView;
    }
}
