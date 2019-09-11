package com.example.vkwall.ul.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPropertyAnimatorListener;
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
import com.example.vkwall.data.model.ProfileWall.GroupWall;
import com.example.vkwall.data.model.ProfileWall.ItemWall;
import com.example.vkwall.data.model.ProfileWall.ProfileWall;
import com.example.vkwall.mvp.likepost.LikeContract;
import com.example.vkwall.mvp.likepost.LikePresenter;
import com.example.vkwall.ul.App;
import com.example.vkwall.ul.main.WallActivity;
import com.example.vkwall.util.SharedPreference;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterWall extends RecyclerView.Adapter<AdapterWall.ViewHolderWall>
        implements LikeContract.ViewLikePost {

    private static String POSTS = "POSTS";
    private static String POST_ID = "POST_ID";
    private static String OWNER_ID = "OWNER_ID";
    private static String TOKEN = "TOKEN";

    private ViewHolderWall viewHolderWall;
    private List<ItemWall> itemWalls;
    private List<ProfileWall> profileWalls;
    private List<GroupWall> groupWalls;

    private LikePresenter presenter;

    public AdapterWall(List<ItemWall> itemWalls, List<ProfileWall> profileWalls, List<GroupWall> groupWalls) {
        this.itemWalls = itemWalls;
        this.profileWalls = profileWalls;
        this.groupWalls = groupWalls;
    }

    @NonNull
    @Override
    public AdapterWall.ViewHolderWall onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.item_list_profile_wall, viewGroup, false);
        viewHolderWall = new ViewHolderWall(view);
        return viewHolderWall;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterWall.ViewHolderWall viewHolderWall, int position) {
        ItemWall itemWall = itemWalls.get(position);
        setData(viewHolderWall, itemWall);
    }

    @Override
    public int getItemCount() {
        return itemWalls.size();
    }

    @Override
    public void showLike(ResponseLike responseLike) {

    }

    @Override
    public void deleteLike(ResponseLike responseLike) {

    }

    class ViewHolderWall extends RecyclerView.ViewHolder {

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

        ViewHolderWall(@NonNull final View itemView) {
            super(itemView);


            presenter = new LikePresenter(((App) itemView.getContext().getApplicationContext()).getDataManager());
            presenter.attachView(AdapterWall.this);


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
    }

    @SuppressLint("SetTextI18n")
    private void setData(final ViewHolderWall viewHolderWall, ItemWall itemWall) {

        final String owner_id = itemWall.getOwnerId().toString();
        final String item_id = itemWall.getId().toString();

        for (ProfileWall profile : profileWalls) {
            if (profile.getId().equals(itemWall.getOwnerId())) {
                viewHolderWall.last_name.setText(profile.getLastName());
                viewHolderWall.first_name.setText(profile.getFirstName());
                Picasso.with(viewHolderWall.itemView.getContext())
                        .load(profile.getPhotoMaxOrig())
                        .into(viewHolderWall.photo_profile);
            }
        }

        for (GroupWall group : groupWalls) {
            viewHolderWall.groups.setVisibility(View.VISIBLE);
            String owners_id = "-" + group.getId();
            if (itemWall.getCopyHistory() != null) {
                if (owners_id.equals(itemWall.getCopyHistory().get(0).getOwnerId().toString())) {
                    viewHolderWall.name_groups.setText(group.getName());
                    Picasso.with(viewHolderWall.itemView.getContext())
                            .load(group.getPhoto50())
                            .into(viewHolderWall.photo_groups);
                }
            } else {
                viewHolderWall.groups.setVisibility(View.GONE);
            }
        }

        viewHolderWall.view_wall_count.setText(itemWall.getViews().getCount().toString());
        viewHolderWall.like_wall_count.setText(itemWall.getLikes().getCount().toString());
        viewHolderWall.comments_wall_count.setText(itemWall.getComments().getCount().toString());

        viewHolderWall.text_wall.setText(itemWall.getText());

        if (itemWall.getAttachments() != null) {
            Picasso.with(viewHolderWall.itemView.getContext())
                    .load(itemWall.getAttachments().get(0).getPhoto().getSizes().get(4).getUrl())
                    .into(viewHolderWall.photo_wall);
        }

        if (itemWall.getCopyHistory() != null) {
            viewHolderWall.text_wall.setText(itemWall.getCopyHistory().get(0).getText());
            Picasso.with(viewHolderWall.itemView.getContext())
                    .load(itemWall.getCopyHistory().get(0).getAttachments().get(0).getPhoto().getSizes().get(4).getUrl())
                    .into(viewHolderWall.photo_wall);
        }

        if (itemWall.getLikes().getUserLikes() == 1) {
            viewHolderWall.like_wall.setImageResource(R.drawable.ic_like_true);
        } else {
            viewHolderWall.like_wall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(viewHolderWall.itemView.getContext(), "Вам понравилась", Toast.LENGTH_LONG).show();
                    presenter.likePostWall("post", owner_id, item_id, SharedPreference.loadToken(viewHolderWall.itemView.getContext()), "5.101");
                    viewHolderWall.like_wall.setImageResource(R.drawable.ic_like_true);
                }
            });
        }
    }
}
