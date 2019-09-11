package com.example.vkwall.mvp.friendswall;

import com.example.vkwall.data.model.GetWallByID.GroupById;
import com.example.vkwall.data.model.GetWallByID.ItemById;
import com.example.vkwall.data.model.GetWallByID.ProfileById;
import com.example.vkwall.data.model.LikeWalls.ResponseLike;
import com.example.vkwall.mvp.base.MvpPresenter;
import com.example.vkwall.mvp.base.MvpView;

import java.util.List;

public interface FriendsWallContract {
    interface ViewFriendsWall extends MvpView {

        void showFriendsWall(List<ItemById> itemByIds, List<ProfileById> profileWalls, List<GroupById> groupWalls);

        void showProgress();

        void hideProgress();

        void noInternet();
    }

    interface PresenterFriendsWall extends MvpPresenter<FriendsWallContract.ViewFriendsWall> {
        void loadFriendsWall(String posts, int extended, String fields, String filter, String access_token, String v);

    }
}
