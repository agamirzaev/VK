package com.example.vkwall.ul.main.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.vkwall.R;
import com.example.vkwall.data.model.FollowersList.ResponseFollowers;
import com.example.vkwall.data.model.Profile.ProfileInfo.Response;
import com.example.vkwall.data.model.ProfileWall.Wall.GroupWall;
import com.example.vkwall.data.model.ProfileWall.Wall.ItemWall;
import com.example.vkwall.data.model.ProfileWall.Wall.ProfileWall;
import com.example.vkwall.dialog.StatusFragment;
import com.example.vkwall.mvp.usersinfo.ProfileFollowersPresenter;
import com.example.vkwall.mvp.usersinfo.ProfileFollowersView;
import com.example.vkwall.mvp.usersinfo.ProfileInfoView;
import com.example.vkwall.mvp.usersinfo.ProfileInfoPresenter;
import com.example.vkwall.ul.App;
import com.example.vkwall.ul.adapter.AdapterWall;
import com.example.vkwall.util.Constant;
import com.example.vkwall.util.SharedPreference;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProfileActivity extends AppCompatActivity implements ProfileInfoView, ProfileFollowersView {
    private String FIELDS = "photo_max_orig,status,city,home_town,photo_50,photo_100";

    private InputMethodManager imm;

    private ProfileInfoPresenter presenter;
    private ProfileFollowersPresenter profileFollowersPresenter;
    private Toolbar toolbar;

    private AdapterWall adapterWall;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private DividerItemDecoration dividerItemDecoration;

    private CollapsingToolbarLayout collapsingToolbarLayout;
    private RelativeLayout status_now, city_profile_now, followers_profile_now, details;

    private ProgressBar progressBar;
    private TextView noInternet;

    private ImageView avatar_profile;

    private TextView status_profile;
    private TextView city_profile;
    private TextView followers_profile;

    private Button edit_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recycler_wall);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        collapsingToolbarLayout = findViewById(R.id.collapsing);
        followers_profile_now = findViewById(R.id.followers_profile_now);
        followers_profile = findViewById(R.id.followers_profile);
        city_profile_now = findViewById(R.id.city_profile_now);
        status_now = findViewById(R.id.status_now);
        details = findViewById(R.id.details);

        progressBar = findViewById(R.id.progress_bar_profile);
        noInternet = findViewById(R.id.no_internet_profile);

        avatar_profile = findViewById(R.id.avatar_profile);
        status_profile = findViewById(R.id.status_profile);
        city_profile = findViewById(R.id.city_profile);

        edit_profile = findViewById(R.id.edit_profile);

        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, DetailsProfileActivity.class);
                startActivity(intent);
            }
        });
        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter = new ProfileInfoPresenter(((App) getApplication()).getDataManager());
        presenter.attachView(this);
        presenter.ProfileInfo(SharedPreference.loadToken(this), Constant.FIELDS, Constant.VERSION);
        profileFollowersPresenter = new ProfileFollowersPresenter(((App) getApplication()).getDataManager());
        profileFollowersPresenter.attachView(this);
        profileFollowersPresenter.showFollowersProfile(SharedPreference.loadToken(this), "photo_100", Constant.VERSION);
        profileFollowersPresenter.showWallProfile(SharedPreference.loadToken(this), 1, "owner", FIELDS, Constant.VERSION);

    }

    @Override
    public void showProfile(Response response) {
        Picasso.get().load(response.getPhotoMaxOrig()).into(avatar_profile);
        collapsingToolbarLayout.setTitle(response.getFirstName() + " " + response.getLastName());

        status_profile.setText(response.getStatus());
        status_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StatusFragment statusFragment = new StatusFragment();
                statusFragment.show(getSupportFragmentManager(), "status");
                imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
            }
        });

        if (response.getCity() == null) {
            city_profile_now.setVisibility(View.GONE);
        } else {
            city_profile_now.setVisibility(View.VISIBLE);
            city_profile.setText(response.getCity().getTitle());
        }
    }

    public void showServices(String status) {
        status_profile.setText(status);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void showFollowers(ResponseFollowers responseFollowers) {
        followers_profile.setText("Подписчики " + responseFollowers.getCount());
    }

    @Override
    public void showWallProfile(List<ItemWall> itemWalls, List<ProfileWall> profileWalls, List<GroupWall> groupWalls) {
        adapterWall = new AdapterWall(itemWalls, profileWalls, groupWalls);
        recyclerView.setAdapter(adapterWall);
    }

    @Override
    public void showProgress() {
        recyclerView.setVisibility(View.GONE);
        edit_profile.setVisibility(View.GONE);
        status_now.setVisibility(View.GONE);
        city_profile_now.setVisibility(View.GONE);
        followers_profile_now.setVisibility(View.GONE);
        details.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        recyclerView.setVisibility(View.VISIBLE);
        edit_profile.setVisibility(View.VISIBLE);
        status_now.setVisibility(View.VISIBLE);
        details.setVisibility(View.VISIBLE);
        followers_profile_now.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showNoInternet() {
        recyclerView.setVisibility(View.GONE);
        edit_profile.setVisibility(View.GONE);
        status_now.setVisibility(View.GONE);
        followers_profile_now.setVisibility(View.GONE);
        details.setVisibility(View.GONE);
        noInternet.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        profileFollowersPresenter.showWallProfile(SharedPreference.loadToken(this), 1, "owner", Constant.FIELDS, Constant.VERSION);

    }
}
