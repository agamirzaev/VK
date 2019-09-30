package com.example.vkwall.mvp.friendsdetails;

import com.example.vkwall.data.model.FollowersList.ResponseFollowers;
import com.example.vkwall.data.model.FriendsInfo.FriendsInfo;
import com.example.vkwall.data.model.FriendsList.ResponseFriends;
import com.example.vkwall.data.model.Profile.AddFriends.FieldsAddFriends;
import com.example.vkwall.data.model.Profile.DeleteFriends.ResponseDelete;
import com.example.vkwall.data.model.ProfileWall.Wall.GroupWall;
import com.example.vkwall.data.model.ProfileWall.Wall.ItemWall;
import com.example.vkwall.data.model.ProfileWall.Wall.ProfileWall;
import com.example.vkwall.mvp.base.MvpPresenter;
import com.example.vkwall.mvp.base.MvpView;

import java.util.List;

public interface FriendsView {
    interface ViewFriends extends MvpView {
        void showFriendsInfo(List<FriendsInfo> friendsInfo);

        void showFriendsCount(ResponseFriends friends);

        void showFollowers(ResponseFollowers responseFollowers);

        void showWallFriends(List<ItemWall> itemWall, List<ProfileWall> profileWalls, List<GroupWall> groupWalls);

        void deleteFriends(ResponseDelete responseDelete);

        void addFriends(FieldsAddFriends fieldsAddFriends);

        void showProgress();

        void hideProgress();

        void noInternet();
    }


    interface PresenterFriends extends MvpPresenter<ViewFriends> {

        void addFriends(String user_id, String access_token, String v);

        void deleteFriends(String user_id, String access_token, String v);

        void loadFriendsInfo(String user_ids, String access_token, String fields, String v);

        void loadFriendsCount(String user_id, String access_token, String count, String fields, String v);

        void loadFollowers(String user_id, String access_token, String fields, String v);

        void loadWallFriends(String user_id, String access_token, int extended, String filter, String fields, String v);
    }

}
