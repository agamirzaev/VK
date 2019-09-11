package com.example.vkwall.ul.main;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.vkwall.R;
import com.example.vkwall.data.model.Profile.PhotosProfile.ItemPhotos;
import com.example.vkwall.data.model.Profile.PhotosProfile.ResponsePhotos;
import com.example.vkwall.mvp.photos.PhotosContract;
import com.example.vkwall.mvp.photos.PhotosPresenter;
import com.example.vkwall.ul.App;
import com.example.vkwall.ul.adapter.AdapterPhotos;
import com.example.vkwall.util.Constant;
import com.example.vkwall.util.SharedPreference;

import java.util.List;

public class PhotosActivity extends AppCompatActivity implements PhotosContract.ViewPhotosProfile {

    private PhotosPresenter photosPresenter;

    private AdapterPhotos adapterPhotos;
    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;

    private TextView count_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        count_photo = findViewById(R.id.count_photo);

        recyclerView = findViewById(R.id.recycler_photos);
        layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);

        photosPresenter = new PhotosPresenter(((App) getApplication()).getDataManager());
        photosPresenter.attachView(this);
        photosPresenter.loadPhotosProfile(SharedPreference.loadToken(this), "wall", 1, Constant.VERSION);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void showPhotosProfile(List<ItemPhotos> itemPhotos) {
        count_photo.setText("Фотографии со стены " + itemPhotos.size());
        adapterPhotos = new AdapterPhotos(itemPhotos);
        recyclerView.setAdapter(adapterPhotos);
    }

    @Override
    public void showProgressPhotos() {

    }

    @Override
    public void hideProgressPhotos() {

    }

    @Override
    public void noInternetPhotos() {

    }
}
