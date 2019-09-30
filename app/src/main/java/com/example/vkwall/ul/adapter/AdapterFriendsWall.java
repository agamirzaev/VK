package com.example.vkwall.ul.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vkwall.R;
import com.example.vkwall.data.model.LikeWalls.ResponseLike;
import com.example.vkwall.data.model.ProfileWall.Wall.GroupWall;
import com.example.vkwall.data.model.ProfileWall.Wall.ItemWall;
import com.example.vkwall.data.model.ProfileWall.Wall.ProfileWall;
import com.example.vkwall.mvp.likepost.LikeContract;
import com.example.vkwall.mvp.likepost.LikePresenter;
import com.example.vkwall.ul.App;
import com.example.vkwall.ul.main.activity.WallActivity;
import com.example.vkwall.util.SharedPreference;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterFriendsWall extends RecyclerView.Adapter<AdapterFriendsWall.HolderWall> {

    public static String POSTS = "POSTS";
    public static String POST_ID = "POST_ID";
    public static String OWNER_ID = "OWNER_ID";
    public static String TOKEN = "TOKEN";

    private HolderWall holderWall;
    private List<ItemWall> itemWalls;
    private List<ProfileWall> profileWalls;
    private List<GroupWall> groupWalls;
    private LikePresenter presenter;
    private int owner_id;
    private int item_id;


    public AdapterFriendsWall(List<ItemWall> itemWalls, List<ProfileWall> profileWalls, List<GroupWall> groupWalls) {
        this.itemWalls = itemWalls;
        this.profileWalls = profileWalls;
        this.groupWalls = groupWalls;
    }

    @NonNull
    @Override
    public AdapterFriendsWall.HolderWall onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_list_wall, parent, false);
        holderWall = new HolderWall(itemView);
        return holderWall;
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n", "ObsoleteSdkInt"})
    @Override
    public void onBindViewHolder(@NonNull final AdapterFriendsWall.HolderWall holderWall, @SuppressLint("RecyclerView") final int position) {
        ItemWall itemWall = itemWalls.get(position);
        setData(holderWall, itemWall);
    }

    @Override
    public int getItemCount() {
        return itemWalls.size();
    }

    class HolderWall extends RecyclerView.ViewHolder implements LikeContract.ViewLikePost {
        private TextView last_name;
        private TextView first_name;
        private ImageView photo_profile;

        private RelativeLayout groups;
        private ImageView photo_groups;
        private TextView name_groups;

        private ImageView photo_wall;
        private TextView text_wall;
        private ImageView like_wall;

        private TextView view_wall_count;
        private TextView like_wall_count;
        private TextView comments_wall_count;
        private ImageView comment_wall;

        HolderWall(@NonNull final View itemView) {
            super(itemView);

            last_name = itemView.findViewById(R.id.last_name);
            first_name = itemView.findViewById(R.id.first_name);
            photo_profile = itemView.findViewById(R.id.photo_profile);
            photo_wall = itemView.findViewById(R.id.photo_wall);
            text_wall = itemView.findViewById(R.id.text_wall);

            like_wall = itemView.findViewById(R.id.like_wall);

            groups = itemView.findViewById(R.id.groups);
            photo_groups = itemView.findViewById(R.id.photo_groups);
            name_groups = itemView.findViewById(R.id.name_groups);

            view_wall_count = itemView.findViewById(R.id.views_wall_count);
            like_wall_count = itemView.findViewById(R.id.like_wall_count);
            comments_wall_count = itemView.findViewById(R.id.comment_wall_count);
            comment_wall = itemView.findViewById(R.id.comment_wall);


            presenter = new LikePresenter(((App) itemView.getContext().getApplicationContext()).getDataManager());
            presenter.attachView(this);

            comment_wall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(), WallActivity.class);
                    intent.putExtra(POSTS, itemWalls.get(getAdapterPosition()).getOwnerId() + "_" + itemWalls.get(getAdapterPosition()).getId());
                    intent.putExtra(POST_ID, itemWalls.get(getAdapterPosition()).getId().toString());
                    intent.putExtra(OWNER_ID, itemWalls.get(getAdapterPosition()).getOwnerId().toString());
                    intent.putExtra(TOKEN, SharedPreference.loadToken(itemView.getContext()));
                    itemView.getContext().startActivity(intent);
                }
            });
        }

        @Override
        public void showLike(ResponseLike responseLike) {

        }

        @Override
        public void deleteLike(ResponseLike responseLike) {

        }
    }

    @SuppressLint("SetTextI18n")
    private void setData(final HolderWall holderWall, ItemWall itemWall) {

        owner_id = itemWall.getOwnerId();
        item_id = itemWall.getId();

        for (ProfileWall profile : profileWalls) {
            if (profile.getId().equals(itemWall.getOwnerId())) {
                holderWall.last_name.setText(profile.getLastName());
                holderWall.first_name.setText(profile.getFirstName());
                Picasso.get()
                        .load(profile.getPhotoMaxOrig())
                        .into(holderWall.photo_profile);
            }
        }

        for (GroupWall groupWall : groupWalls) {
            holderWall.groups.setVisibility(View.VISIBLE);
            String owners_id = "-" + groupWall.getId();
            if (itemWall.getCopyHistory() != null) {
                if (owners_id.equals(itemWall.getCopyHistory().get(0).getOwnerId().toString())) {
                    holderWall.name_groups.setText(groupWall.getName());
                    Picasso.get()
                            .load(groupWall.getPhoto50())
                            .into(holderWall.photo_groups);
                }
            } else {
                holderWall.groups.setVisibility(View.GONE);
            }
        }

        holderWall.view_wall_count.setText(itemWall.getViews().getCount().toString());
        holderWall.like_wall_count.setText(itemWall.getLikes().getCount().toString());
        holderWall.comments_wall_count.setText(itemWall.getComments().getCount().toString());

        holderWall.text_wall.setText(itemWall.getText());

        if (itemWall.getAttachments() != null) {
            if (itemWall.getAttachments().get(0).getPhoto().getText() != "") {
                holderWall.text_wall.setText(itemWall.getText());
            }
            Picasso.get()
                    .load(itemWall.getAttachments().get(0).getPhoto().getSizes().get(4).getUrl())
                    .into(holderWall.photo_wall);
        }

        if (itemWall.getCopyHistory() != null) {
            holderWall.text_wall.setText(itemWall.getCopyHistory().get(0).getText());
            Picasso.get()
                    .load(itemWall.getCopyHistory().get(0).getAttachments().get(0).getPhoto().getSizes().get(4).getUrl())
                    .into(holderWall.photo_wall);
        }

        getLike(itemWall);
    }

    private void getLike(ItemWall itemWall) {
        if (itemWall.getLikes().getUserLikes() == 1) {
            holderWall.like_wall.setImageResource(R.drawable.ic_like_true);
        } else {
            holderWall.like_wall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(holderWall.itemView.getContext(), "Вам понравилась", Toast.LENGTH_LONG).show();
                    presenter.likePostWall("post", owner_id, item_id, SharedPreference.loadToken(holderWall.itemView.getContext()), "5.101");
                    holderWall.like_wall.setImageResource(R.drawable.ic_like_true);
                }
            });
        }
    }
}