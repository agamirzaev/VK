package com.example.vkwall.ul.main.activity;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.vkwall.R;
import com.example.vkwall.data.model.Profile.PhotosProfile.ItemPhotos;
import com.example.vkwall.data.model.Profile.PhotosProfile.ResponsePhotos;
import com.example.vkwall.mvp.photos.PhotosContract;
import com.example.vkwall.mvp.photos.PhotosPresenter;
import com.example.vkwall.ul.App;
import com.example.vkwall.ul.adapter.AdapterPhotoSaved;
import com.example.vkwall.ul.adapter.AdapterPhotos;
import com.example.vkwall.util.Constant;
import com.example.vkwall.util.SharedPreference;

import java.util.List;

public class PhotosActivity extends AppCompatActivity implements PhotosContract.ViewPhotosProfile {

    private Toolbar toolbar;
    private ProgressBar progressBar;
    private TextView noInternet;
    private TextView photo_count_wall;
    private TextView photo_count_saved;

    private PhotosPresenter photosPresenter;
    private AdapterPhotos adapterPhotos;
    private AdapterPhotoSaved adapterPhotoSaved;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;
    private RecyclerView recyclerPhotoSaved;
    private GridLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Фотографии");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        photo_count_wall = findViewById(R.id.photo_count_wall);
        photo_count_saved = findViewById(R.id.photo_count_saved);

        progressBar = findViewById(R.id.progress_bar);
        noInternet = findViewById(R.id.no_internet);

        recyclerView = findViewById(R.id.recycler_photos);
        layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);

        recyclerPhotoSaved = findViewById(R.id.recycler_photos_saved);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerPhotoSaved.setLayoutManager(linearLayoutManager);

        photosPresenter = new PhotosPresenter(((App) getApplication()).getDataManager());
        photosPresenter.attachView(this);
        photosPresenter.loadPhotosProfile(SharedPreference.loadToken(this), Constant.VERSION);
        photosPresenter.loadPhotoSaved(SharedPreference.loadToken(this), "saved", Constant.VERSION);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void showPhotosProfile(List<ItemPhotos> itemPhotos) {
        photo_count_wall.setText("Все фотографии " + itemPhotos.size());
        adapterPhotos = new AdapterPhotos(itemPhotos);
        recyclerView.setAdapter(adapterPhotos);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void showPhotoSaved(List<ItemPhotos> itemPhotos) {
        photo_count_saved.setText("Сохраненки " + itemPhotos.size());
        adapterPhotoSaved = new AdapterPhotoSaved(itemPhotos);
        recyclerPhotoSaved.setAdapter(adapterPhotoSaved);
    }

    @Override
    public void showProgressPhotos() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressPhotos() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void noInternetPhotos() {
        noInternet.setVisibility(View.VISIBLE);
    }
}
