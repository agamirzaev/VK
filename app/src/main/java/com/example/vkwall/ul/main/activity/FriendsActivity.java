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
import com.example.vkwall.data.model.FriendsList.ItemFriends;
import com.example.vkwall.mvp.main.MainContract;
import com.example.vkwall.mvp.main.MainPresenter;
import com.example.vkwall.ul.App;
import com.example.vkwall.ul.adapter.AdapterFriends;
import com.example.vkwall.util.Constant;
import com.example.vkwall.util.SharedPreference;

import java.util.List;

public class FriendsActivity extends AppCompatActivity implements MainContract.View {

    private MainPresenter presenter;
    private AdapterFriends adapterFriends;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private DividerItemDecoration dividerItemDecoration;

    private ProgressBar progressBar;
    private TextView noInternet;

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Друзья");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recycler_friends);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        progressBar = findViewById(R.id.progress_home);
        noInternet = findViewById(R.id.no_internet);

        presenter = new MainPresenter(((App) getApplication()).getDataManager());
        presenter.attachView(FriendsActivity.this);
        presenter.loadFriends(SharedPreference.loadToken(this), "photo_max_orig,online", "5.101");
    }

    @Override
    public void showFriends(List<ItemFriends> itemFriends) {
        adapterFriends = new AdapterFriends(itemFriends);
        recyclerView.setAdapter(adapterFriends);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void noInternet() {
        noInternet.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadFriends(SharedPreference.loadToken(this), Constant.FIELDS, Constant.VERSION);
    }
}
