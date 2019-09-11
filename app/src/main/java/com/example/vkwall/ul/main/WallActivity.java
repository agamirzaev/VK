package com.example.vkwall.ul.main;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vkwall.R;
import com.example.vkwall.data.model.FollowersList.ResponseFollowers;
import com.example.vkwall.data.model.GetWallByID.GroupById;
import com.example.vkwall.data.model.GetWallByID.ItemById;
import com.example.vkwall.data.model.GetWallByID.ProfileById;
import com.example.vkwall.data.model.LikeWalls.ResponseLike;
import com.example.vkwall.data.model.ProfileWall.GroupWall;
import com.example.vkwall.data.model.ProfileWall.ItemWall;
import com.example.vkwall.data.model.ProfileWall.ProfileWall;
import com.example.vkwall.mvp.friendswall.FriendsWallContract;
import com.example.vkwall.mvp.friendswall.FriendsWallPresenter;
import com.example.vkwall.mvp.likepost.LikeContract;
import com.example.vkwall.mvp.likepost.LikePresenter;
import com.example.vkwall.mvp.usersinfo.ProfileFollowersPresenter;
import com.example.vkwall.mvp.usersinfo.ProfileFollowersView;
import com.example.vkwall.ul.App;
import com.example.vkwall.ul.adapter.AdapterFriendsWall;
import com.example.vkwall.util.Constant;
import com.example.vkwall.util.SharedPreference;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WallActivity extends AppCompatActivity implements FriendsWallContract.ViewFriendsWall,
        LikeContract.ViewLikePost {
    private String FIELDS = "photo_max_orig,status,city,home_town,photo_50,photo_100";
    private String VERSION = "5.101";
    private int EXTENDED = 1;
    private String FILTER = "owner";

    private String posts;
    private String token;
    private String post_id;
    private String owner_id;

    private FriendsWallPresenter presenter;
    private LikePresenter likePresenter;

    private TextView last_name;
    private TextView first_name;
    private ImageView imageView;

    private LinearLayout groups;
    private LinearLayout likes;
    private ImageView photo_groups;
    private TextView name_groups;

    private TextView count_like_walls;
    private TextView count_views_walls;

    private ProgressBar progressBarWall;
    private TextView noInternet;

    private TextView comment_can_post;

    private TextView text_wall;
    private ImageView photo_walls;

    private ImageView like_walls;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall);

        last_name = findViewById(R.id.last_name);
        first_name = findViewById(R.id.first_name);
        imageView = findViewById(R.id.photo_profiles);
        text_wall = findViewById(R.id.text_wall);
        photo_walls = findViewById(R.id.photo_walls);

        like_walls = findViewById(R.id.like_walls);

        likes = findViewById(R.id.likes);
        progressBarWall = findViewById(R.id.progress_bar_wall);
        noInternet = findViewById(R.id.no_internet_wall);

        groups = findViewById(R.id.groups);
        photo_groups = findViewById(R.id.photo_groups);
        name_groups = findViewById(R.id.name_groups);

        count_like_walls = findViewById(R.id.count_like_walls);
        count_views_walls = findViewById(R.id.count_views_walls);

        comment_can_post = findViewById(R.id.comment_can_post);

        posts = getIntent().getStringExtra(AdapterFriendsWall.POSTS);
        token = getIntent().getStringExtra(AdapterFriendsWall.TOKEN);
        owner_id = getIntent().getStringExtra(AdapterFriendsWall.OWNER_ID);
        post_id = getIntent().getStringExtra(AdapterFriendsWall.POST_ID);


        likePresenter = new LikePresenter(((App) getApplication()).getDataManager());
        likePresenter.attachView(WallActivity.this);

        presenter = new FriendsWallPresenter(((App) getApplication()).getDataManager());
        presenter.attachView(WallActivity.this);
        presenter.loadFriendsWall(posts, EXTENDED, FIELDS, FILTER, token, VERSION);


    }

    @SuppressLint("SetTextI18n")
    @Override
    public void showFriendsWall(final List<ItemById> itemByIds, List<ProfileById> profileByIds, List<GroupById> groupByIds) {

        for (final ItemById items : itemByIds) {
            likes.setVisibility(View.VISIBLE);
            for (ProfileById profileById : profileByIds) {
                last_name.setText(profileById.getLastName());
                first_name.setText(profileById.getFirstName());
                Picasso.with(this)
                        .load(profileById.getPhoto100())
                        .into(imageView);
            }

            for (GroupById groupById : groupByIds) {
                groups.setVisibility(View.VISIBLE);
                String owner_id = "-" + groupById.getId();
                if (items.getCopyHistoryWalls() != null) {
                    if (owner_id.equals(items.getCopyHistoryWalls().get(0).getOwnerId() + "")) {
                        name_groups.setText(groupById.getName());
                        Picasso.with(this).load(groupById.getPhoto100()).into(photo_groups);
                    }
                } else {
                    groups.setVisibility(View.GONE);
                }

            }

            text_wall.setText(items.getText());
            count_like_walls.setText(items.getLikes().getCount().toString());
            count_views_walls.setText(items.getViews().getCount().toString());


            if (items.getAttachments() != null) {
                if (items.getText() != "") {
                    text_wall.setText(items.getText());
                }

                Picasso.with(WallActivity.this)
                        .load(items.getAttachments().get(0).getPhoto().getSizes().get(4).getUrl())
                        .into(photo_walls);
            }

            if (items.getComments().getCanPost() == 0) {
                comment_can_post.setText("Комментарии отключены");
            } else if (items.getComments().getCanPost() == 1) {
                if (items.getComments().getCount() > 0) {
                    comment_can_post.setText("Комментарий есть");
                } else {
                    comment_can_post.setText("Комментарий нет");
                }

            }

            if (items.getCopyHistoryWalls() != null) {
                if (items.getCopyHistoryWalls().get(0).getText() != "") {
                    text_wall.setText(items.getCopyHistoryWalls().get(0).getText());
                }
                Picasso.with(WallActivity.this)
                        .load(items.getCopyHistoryWalls().get(0).getAttachments().get(0).getPhoto().getSizes().get(4).getUrl())
                        .into(photo_walls);
            }

            if (items.getLikes().getUserLikes() != 0) {
                like_walls.setImageDrawable(getDrawable(R.drawable.ic_like_true));
            } else {
                like_walls.setImageDrawable(getDrawable(R.drawable.ic_like));
            }

            like_walls.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (items.getLikes().getUserLikes() == 1) {
                        Toast.makeText(WallActivity.this, "Вы убрали Нравиться", Toast.LENGTH_LONG).show();
                        likePresenter.deleteLike("post", owner_id, post_id, token, VERSION);
                    } else if (items.getLikes().getUserLikes() == 0) {
                        presenter.loadFriendsWall(posts, EXTENDED, FIELDS, FILTER, token, VERSION);
                        Toast.makeText(WallActivity.this, "Вам Нравиться", Toast.LENGTH_LONG).show();
                        likePresenter.likePostWall("post", owner_id, post_id, token, VERSION);
                    }
                }
            });
        }
    }

    @Override
    public void showProgress() {
        progressBarWall.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBarWall.setVisibility(View.GONE);
    }

    @Override
    public void noInternet() {
        noInternet.setVisibility(View.VISIBLE);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void showLike(ResponseLike responseLike) {
        like_walls.setImageDrawable(getDrawable(R.drawable.ic_like_true));
        count_like_walls.setText(responseLike.getLikes() + "");
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void deleteLike(ResponseLike responseLike) {
        like_walls.setImageDrawable(getDrawable(R.drawable.ic_like));
        count_like_walls.setText(responseLike.getLikes() + "");
    }

}
