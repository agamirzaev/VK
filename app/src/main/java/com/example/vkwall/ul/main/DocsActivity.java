package com.example.vkwall.ul.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.vkwall.R;
import com.example.vkwall.data.model.Profile.DocsProfile.ItemDocs;
import com.example.vkwall.data.model.Profile.DocsProfile.ResponseDocs;
import com.example.vkwall.data.model.Profile.GroupProfile.ItemGroup;
import com.example.vkwall.mvp.docs.DocsContract;
import com.example.vkwall.mvp.docs.DocsPresenter;
import com.example.vkwall.ul.App;
import com.example.vkwall.ul.adapter.AdapterDocs;
import com.example.vkwall.util.Constant;
import com.example.vkwall.util.SharedPreference;

import java.util.List;

public class DocsActivity extends AppCompatActivity implements DocsContract.ViewDocsProfile {

    private DocsPresenter docsPresenter;

    private AdapterDocs adapterDocs;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private DividerItemDecoration dividerItemDecoration;

    private ProgressBar progressBar;
    private TextView noInternet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_docs);

        recyclerView = findViewById(R.id.recycler_docs);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);


        docsPresenter = new DocsPresenter(((App) getApplication()).getDataManager());
        docsPresenter.attachView(this);
        docsPresenter.loadDocsProfile(SharedPreference.loadToken(this), Constant.VERSION);
    }

    @Override
    public void showDocsProfile(List<ItemDocs> itemDocs) {
        adapterDocs = new AdapterDocs(itemDocs);
        recyclerView.setAdapter(adapterDocs);
    }

    @Override
    public void showProgressDocs() {

    }

    @Override
    public void hideProgressDocs() {

    }

    @Override
    public void noInternetDocs() {

    }
}
