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
import com.example.vkwall.data.model.Profile.GroupProfile.ItemGroup;
import com.example.vkwall.data.model.Profile.GroupProfile.ResponseGroup;
import com.example.vkwall.data.model.Profile.VideoProfile.ResponseVideo;
import com.example.vkwall.mvp.groups.GroupsContract;
import com.example.vkwall.mvp.groups.GroupsPresenter;
import com.example.vkwall.ul.App;
import com.example.vkwall.ul.adapter.AdapterGroups;
import com.example.vkwall.util.Constant;
import com.example.vkwall.util.SharedPreference;

import java.util.List;

public class GroupActivity extends AppCompatActivity implements GroupsContract.ViewGroupsProfile {

    private Toolbar toolbar;
    private ProgressBar progressBar;
    private TextView noInternet;

    private GroupsPresenter presenter;
    private AdapterGroups adapterGroups;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private DividerItemDecoration dividerItemDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Группы");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressBar = findViewById(R.id.progress_bar);
        noInternet = findViewById(R.id.no_internet);

        recyclerView = findViewById(R.id.recycler_groups);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        presenter = new GroupsPresenter(((App) getApplication()).getDataManager());
        presenter.attachView(this);
        presenter.loadGroupsProfile(SharedPreference.loadToken(this), 1, Constant.VERSION);
    }

    @Override
    public void showGroupsProfile(List<ItemGroup> itemGroup) {
        adapterGroups = new AdapterGroups(itemGroup);
        recyclerView.setAdapter(adapterGroups);
    }

    @Override
    public void showProgressGroups() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressGroups() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void noInternetGroups() {
        noInternet.setVisibility(View.VISIBLE);
    }
}
