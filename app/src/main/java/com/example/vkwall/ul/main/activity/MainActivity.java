package com.example.vkwall.ul.main.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.vkwall.R;
import com.example.vkwall.ul.main.fragment.HomeFragment;
import com.example.vkwall.ul.main.fragment.NewsFeedFragment;
import com.example.vkwall.ul.main.fragment.NotificationFragment;
import com.example.vkwall.util.SharedPreference;
import com.vk.api.sdk.VK;
import com.vk.api.sdk.auth.VKAccessToken;
import com.vk.api.sdk.auth.VKAuthCallback;
import com.vk.api.sdk.auth.VKScope;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private VKScope[] vkScopes = new VKScope[]{
            VKScope.FRIENDS,
            VKScope.WALL,
            VKScope.DOCS,
            VKScope.GROUPS,
            VKScope.PHOTOS,
            VKScope.VIDEO,
            VKScope.STATUS,
            VKScope.NOTIFICATIONS
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!VK.isLoggedIn()) {
            VK.login(this, Arrays.asList(vkScopes));
        } else {
            loadHomeFragment(new NewsFeedFragment());
        }

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private boolean loadHomeFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragments, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VK.onActivityResult(requestCode, resultCode, data, new VKAuthCallback() {
            @Override
            public void onLoginFailed(int i) {
                Toast.makeText(MainActivity.this, "ERROR!!!" + i, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLogin(@NotNull VKAccessToken vkAccessToken) {
                SharedPreference.saveToken(vkAccessToken.getAccessToken(), MainActivity.this);
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            int id = item.getItemId();
            switch (id) {
                case R.id.newsfeed:
                    fragment = new NewsFeedFragment();
                    break;
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    break;

                case R.id.navigation_notification:
                    fragment = new NotificationFragment();
                    break;
            }
            return loadHomeFragment(fragment);
        }
    };

}
