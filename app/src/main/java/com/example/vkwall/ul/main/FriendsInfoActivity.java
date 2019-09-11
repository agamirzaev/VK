package com.example.vkwall.ul.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vkwall.R;
import com.example.vkwall.data.model.FollowersList.ResponseFollowers;
import com.example.vkwall.data.model.FriendsInfo.FriendsInfo;
import com.example.vkwall.data.model.FriendsList.ResponseFriends;
import com.example.vkwall.data.model.Profile.AddFriends.FieldsAddFriends;
import com.example.vkwall.data.model.Profile.DeleteFriends.ResponseDelete;
import com.example.vkwall.data.model.ProfileWall.GroupWall;
import com.example.vkwall.data.model.ProfileWall.ItemWall;
import com.example.vkwall.data.model.ProfileWall.ProfileWall;
import com.example.vkwall.mvp.friendsdetails.FriendsView;
import com.example.vkwall.mvp.friendsdetails.FriendsPresenter;
import com.example.vkwall.ul.App;
import com.example.vkwall.ul.adapter.AdapterFriends;
import com.example.vkwall.ul.adapter.AdapterFriendsWall;
import com.example.vkwall.util.Constant;
import com.example.vkwall.util.SharedPreference;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FriendsInfoActivity extends AppCompatActivity implements FriendsView.ViewFriends {
    private String FIELDS = "photo_max_orig,status,city,home_town,photo_50,photo_100";
    private String VERSION = "5.101";
    private String COUNT = "5000";
    private int EXTENDED = 1;
    private String FILTER = "owner";

    private String user_id;
    private String token;

    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    private FriendsPresenter presenter;
    private AdapterFriendsWall adapterFriendsWall;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    private ImageView avatar_profile;
    private TextView status_profile;
    private TextView city_profile;
    private TextView friends_profile;
    private TextView followers_profile;
    private RelativeLayout status_now, city_profile_now, followers_profile_now, friends_profile_now;
    private ProgressBar progressBar;
    private TextView noInternet;

    private Button deleteFriends, add_friends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_info);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout = findViewById(R.id.collapsing);
        followers_profile_now = findViewById(R.id.followers_profile_now);
        friends_profile_now = findViewById(R.id.friends_profile_now);

        deleteFriends = findViewById(R.id.delete_friends);
        add_friends = findViewById(R.id.add_friends);

        recyclerView = findViewById(R.id.recycler_wall);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        user_id = getIntent().getStringExtra(AdapterFriends.USER_IDS);
        token = getIntent().getStringExtra(AdapterFriends.TOKEN);

        avatar_profile = findViewById(R.id.avatar_profile);
        status_profile = findViewById(R.id.status_profile);
        city_profile = findViewById(R.id.city_profile);
        status_now = findViewById(R.id.status_now);
        friends_profile = findViewById(R.id.friends_profile);
        city_profile_now = findViewById(R.id.city_profile_now);
        followers_profile = findViewById(R.id.followers_profile);
        progressBar = findViewById(R.id.progress_bar);
        noInternet = findViewById(R.id.no_internet);


        presenter = new FriendsPresenter(((App) getApplication()).getDataManager());
        presenter.attachView(FriendsInfoActivity.this);
        presenter.loadFriendsInfo(user_id, token, FIELDS, VERSION);
        presenter.loadFriendsCount(user_id, token, COUNT, FIELDS, VERSION);
        presenter.loadFollowers(user_id, token, FIELDS, VERSION);
        presenter.loadWallFriends(user_id, token, EXTENDED, FILTER, FIELDS, VERSION);

        add_friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FriendsInfoActivity.this, "Пользователь добавлен в друзья", Toast.LENGTH_SHORT).show();
                presenter.addFriends(user_id, token, Constant.VERSION);
            }
        });

        deleteFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FriendsInfoActivity.this, "Пользователь удален из друзей", Toast.LENGTH_SHORT).show();
                presenter.deleteFriends(user_id, token, Constant.VERSION);
            }
        });

    }


    @Override
    public void showFriendsInfo(List<FriendsInfo> friendsInfo) {
        for (FriendsInfo friends : friendsInfo) {
            Picasso.with(FriendsInfoActivity.this).load(friends.getPhotoMaxOrig()).into(avatar_profile);
            collapsingToolbarLayout.setTitle(friends.getLastName() + " " + friends.getFirstName());
            if (friends.getStatus().equals("")) {
                status_now.setVisibility(View.GONE);
            } else {
                status_now.setVisibility(View.VISIBLE);
                status_profile.setText(friends.getStatus());
            }

            if (friends.getCity() == null) {
                city_profile_now.setVisibility(View.GONE);
            } else {
                city_profile_now.setVisibility(View.VISIBLE);
                city_profile.setText(friends.getCity().getTitle());
            }
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void showFriendsCount(ResponseFriends friends) {
        friends_profile.setText("Друзья " + friends.getCount());
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void showFollowers(ResponseFollowers responseFollowers) {
        followers_profile.setText("Подписчики " + responseFollowers.getCount());
    }

    @Override
    public void showWallFriends(List<ItemWall> itemWall, List<ProfileWall> profileWalls, List<GroupWall> groupWalls) {
        adapterFriendsWall = new AdapterFriendsWall(itemWall, profileWalls, groupWalls);
        recyclerView.setAdapter(adapterFriendsWall);
    }

    @Override
    public void deleteFriends(ResponseDelete responseDelete) {
        if (responseDelete.getSuccess() == 1) {
            deleteFriends.setVisibility(View.GONE);
            add_friends.setVisibility(View.VISIBLE);
        } else {
            add_friends.setVisibility(View.GONE);
        }
    }

    @Override
    public void addFriends(FieldsAddFriends fieldsAddFriends) {
        deleteFriends.setVisibility(View.VISIBLE);
        add_friends.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        status_now.setVisibility(View.GONE);
        city_profile_now.setVisibility(View.GONE);
        friends_profile_now.setVisibility(View.GONE);
        followers_profile_now.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        friends_profile_now.setVisibility(View.VISIBLE);
        followers_profile_now.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void noInternet() {
        noInternet.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadFriendsInfo(user_id, token, FIELDS, VERSION);
        presenter.loadFriendsCount(user_id, token, COUNT, FIELDS, VERSION);
        presenter.loadFollowers(user_id, token, FIELDS, VERSION);
        presenter.loadWallFriends(user_id, token, EXTENDED, FILTER, FIELDS, VERSION);
    }
}

