package com.example.vkwall.ul.main.activity;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.vkwall.R;
import com.example.vkwall.data.model.Profile.ProfileInfo.Response;
import com.example.vkwall.mvp.usersinfo.ProfileInfoPresenter;
import com.example.vkwall.mvp.usersinfo.ProfileInfoView;
import com.example.vkwall.ul.App;
import com.example.vkwall.util.Constant;
import com.example.vkwall.util.SharedPreference;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DetailsProfileActivity extends AppCompatActivity implements ProfileInfoView {

    private ProfileInfoPresenter presenter;

    private Toolbar toolbar;

    private ProgressBar progressBar;
    private TextView noInternet;

    private TextView status;
    private TextView data;
    private TextView home_town;
    private TextView marital_status;
    private TextView language;
    private TextView home;
    private TextView life_position;
    private TextView main_thing_life;
    private TextView main_thing_people;
    private TextView smoking;
    private TextView alcohol;
    private TextView active;
    private TextView interesting;
    private TextView life_music;
    private TextView life_films;
    private TextView life_books;
    private TextView life_game;
    private TextView life_quote;
    private TextView about;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_profile);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressBar = findViewById(R.id.progress_bar);
        noInternet = findViewById(R.id.no_internet);

        presenter = new ProfileInfoPresenter(((App) getApplication()).getDataManager());
        presenter.attachView(this);
        presenter.ProfileInfo(SharedPreference.loadToken(this), Constant.FIELDS, Constant.VERSION);

        status = findViewById(R.id.status);
        data = findViewById(R.id.data);
        home_town = findViewById(R.id.home_town);
        marital_status = findViewById(R.id.marital_status);
        language = findViewById(R.id.language);
        home = findViewById(R.id.home);
        life_position = findViewById(R.id.life_position);
        main_thing_life = findViewById(R.id.main_thing_life);
        main_thing_people = findViewById(R.id.main_thing_people);
        smoking = findViewById(R.id.smoking);
        alcohol = findViewById(R.id.alcohol);
        active = findViewById(R.id.active);
        interesting = findViewById(R.id.interesting);
        life_music = findViewById(R.id.life_music);
        life_films = findViewById(R.id.life_films);
        life_books = findViewById(R.id.life_books);
        life_game = findViewById(R.id.life_game);
        life_quote = findViewById(R.id.life_quote);
        about = findViewById(R.id.about);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void showProfile(Response response) {
        getSupportActionBar().setTitle(response.getFirstName() + " " + response.getLastName());
        status.setText(response.getStatus());
        data.setText(response.getBdate());
        home_town.setText(response.getHomeTown());

        if (response.getRelation() == 1) {
            marital_status.setText("Не женат");
        }

        language.setText(response.getPersonal().getLangs().get(0));
        home.setText(response.getCity().getTitle());
        life_position.setText(response.getPersonal().getReligion());

        if (response.getPersonal().getLifeMain() == 6) {
            main_thing_life.setText("Саморазвитие");
        }

        if (response.getPersonal().getPeopleMain() == 2) {
            main_thing_people.setText("Добрата и честность");
        }

        if (response.getPersonal().getSmoking() == 3) {
            smoking.setText("Компромиссное");
        }

        if (response.getPersonal().getAlcohol() == 3) {
            alcohol.setText("Компромиссное");
        }


        active.setText(response.getActivities());
        interesting.setText(response.getInterests());
        life_music.setText(response.getMusic());
        life_films.setText(response.getMovies());
        life_books.setText(response.getBooks());
        life_game.setText(response.getGames());
        life_quote.setText(response.getQuotes());
        about.setText(response.getAbout());
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
    public void showNoInternet() {
        noInternet.setVisibility(View.VISIBLE);
    }
}
