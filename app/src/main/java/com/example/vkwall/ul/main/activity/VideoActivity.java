package com.example.vkwall.ul.main.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.vkwall.R;
import com.example.vkwall.data.model.Profile.VideoProfile.ItemVideo;
import com.example.vkwall.mvp.video.VideoContract;
import com.example.vkwall.mvp.video.VideoPresenter;
import com.example.vkwall.ul.App;
import com.example.vkwall.ul.adapter.AdapterVideo;
import com.example.vkwall.util.Constant;
import com.example.vkwall.util.SharedPreference;

import java.util.List;

public class VideoActivity extends AppCompatActivity implements VideoContract.ViewVideoProfile {

    private VideoPresenter videoPresenter;
    private Toolbar toolbar;

    private AdapterVideo adapterVideo;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private DividerItemDecoration dividerItemDecoration;

    private ProgressBar progressBar;
    private TextView noInternet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Видеозаписи");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recycler_video);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        progressBar = findViewById(R.id.progress_video);
        noInternet = findViewById(R.id.no_internet);

        videoPresenter = new VideoPresenter(((App) getApplication()).getDataManager());
        videoPresenter.attachView(this);
        videoPresenter.loadVideoProfile(SharedPreference.loadToken(this), 1, Constant.VERSION);
    }


    @Override
    public void showVideoProfile(List<ItemVideo> itemVideo) {
        adapterVideo = new AdapterVideo(itemVideo);
        recyclerView.setAdapter(adapterVideo);
    }

    @Override
    public void showProgressVideo() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressVideo() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void noInternetVideo() {
        noInternet.setVisibility(View.VISIBLE);
    }
}
