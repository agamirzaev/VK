package com.example.vkwall.mvp.likepost;

import com.example.vkwall.data.model.LikeWalls.ResponseLike;
import com.example.vkwall.mvp.base.MvpPresenter;
import com.example.vkwall.mvp.base.MvpView;


public interface LikeContract {
    interface ViewLikePost extends MvpView {

        void showLike(ResponseLike responseLike);

        void deleteLike(ResponseLike responseLike);
    }

    interface PresenterLikePost extends MvpPresenter<LikeContract.ViewLikePost> {
        void likePostWall(String type, String owner_id, String item_id, String access_token, String v);

        void deleteLike(String type, String owner_id, String item_id, String access_token, String v);
    }
}
