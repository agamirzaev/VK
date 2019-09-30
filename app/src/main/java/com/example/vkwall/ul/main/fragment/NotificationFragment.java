package com.example.vkwall.ul.main.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.vkwall.R;
import com.example.vkwall.data.model.Notification.ItemNotif;
import com.example.vkwall.data.model.Notification.ProfileNotif;
import com.example.vkwall.mvp.notifications.NotificationsContract;
import com.example.vkwall.mvp.notifications.NotificationsPresenter;
import com.example.vkwall.ul.App;
import com.example.vkwall.ul.adapter.AdapterNotification;
import com.example.vkwall.util.SharedPreference;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment implements NotificationsContract.ViewNotifications {

    private NotificationsPresenter presenter;

    private AdapterNotification adapterNotification;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private DividerItemDecoration dividerItemDecoration;

    private ProgressBar progressBar;
    private TextView noInternet;

    private Toolbar toolbar;


    public NotificationFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle("Уведомления");

        recyclerView = view.findViewById(R.id.recycler_notification);
        layoutManager = new LinearLayoutManager(
                getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        progressBar = view.findViewById(R.id.progress_bar_notif);
        noInternet = view.findViewById(R.id.no_internet);

        presenter = new NotificationsPresenter(((App) getActivity().getApplication()).getDataManager());
        presenter.attachView(NotificationFragment.this);
        presenter.loadNotifications(SharedPreference.loadToken(getContext()), "friends", "5.101");

        return view;
    }

    @Override
    public void showNotifications(List<ItemNotif> itemNotifs, List<ProfileNotif> profileNotifs) {
        adapterNotification = new AdapterNotification(itemNotifs, profileNotifs);
        recyclerView.setAdapter(adapterNotification);
    }

    @Override
    public void showProgressNotifications() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressNotifications() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void noInternetNotifications() {
        noInternet.setVisibility(View.VISIBLE);
    }
}
