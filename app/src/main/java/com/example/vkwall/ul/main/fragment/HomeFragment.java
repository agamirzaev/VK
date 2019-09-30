package com.example.vkwall.ul.main.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.vkwall.R;
import com.example.vkwall.data.model.Profile.ProfileInfo.Response;
import com.example.vkwall.mvp.usersinfo.ProfileInfoView;
import com.example.vkwall.mvp.usersinfo.ProfileInfoPresenter;
import com.example.vkwall.ul.App;
import com.example.vkwall.ul.main.activity.DocsActivity;
import com.example.vkwall.ul.main.activity.FaveActivity;
import com.example.vkwall.ul.main.activity.FriendsActivity;
import com.example.vkwall.ul.main.activity.GroupActivity;
import com.example.vkwall.ul.main.activity.PhotosActivity;
import com.example.vkwall.ul.main.activity.ProfileActivity;
import com.example.vkwall.ul.main.activity.SearchActivity;
import com.example.vkwall.ul.main.activity.VideoActivity;
import com.example.vkwall.util.Constant;
import com.example.vkwall.util.SharedPreference;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements ProfileInfoView {
    private ProfileInfoPresenter presenter;

    private Toolbar toolbar;

    private ImageView photo_profile;
    private TextView last_first_name;

    private ProgressBar progressBar;
    private TextView no_internet;
    private RelativeLayout profile_info;
    private LinearLayout l1, l1_friends, l1_photo, l1_video, l1_fave, l1_groups, l1_docs, l1_search;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle("Профиль");

        photo_profile = view.findViewById(R.id.photo_profile);
        last_first_name = view.findViewById(R.id.last_first_name);
        progressBar = view.findViewById(R.id.progress_profile);
        no_internet = view.findViewById(R.id.no_internet);
        profile_info = view.findViewById(R.id.profile_info);

        l1 = view.findViewById(R.id.l1);
        l1_friends = view.findViewById(R.id.l1_friends);
        l1_groups = view.findViewById(R.id.l1_group);
        l1_photo = view.findViewById(R.id.l1_photos);
        l1_video = view.findViewById(R.id.l1_video);
        l1_docs = view.findViewById(R.id.l1_docs);
        l1_fave = view.findViewById(R.id.l1_fave);
        l1_search = view.findViewById(R.id.l1_search);

        presenter = new ProfileInfoPresenter(((App) getActivity().getApplication()).getDataManager());
        presenter.attachView(HomeFragment.this);
        presenter.ProfileInfo(SharedPreference.loadToken(view.getContext()), Constant.FIELDS, Constant.VERSION);

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ProfileActivity.class);
                view.getContext().startActivity(intent);
            }
        });
        l1_friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), FriendsActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        l1_fave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), FaveActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        l1_docs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DocsActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        l1_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), VideoActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        l1_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PhotosActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        l1_groups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), GroupActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        l1_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SearchActivity.class);
                view.getContext().startActivity(intent);
            }
        });
        return view;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void showProfile(Response response) {
        Picasso.get().load(response.getPhotoMaxOrig()).into(photo_profile);
        last_first_name.setText(response.getLastName() + " " + response.getFirstName());
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        profile_info.setVisibility(View.VISIBLE);
    }

    @Override
    public void showNoInternet() {
        no_internet.setVisibility(View.VISIBLE);
        profile_info.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
    }
}
