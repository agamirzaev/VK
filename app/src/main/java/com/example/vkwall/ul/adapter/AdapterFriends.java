package com.example.vkwall.ul.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vkwall.R;
import com.example.vkwall.data.model.FriendsInfo.FriendsInfo;
import com.example.vkwall.data.model.FriendsList.ItemFriends;
import com.example.vkwall.ul.main.FriendsInfoActivity;
import com.example.vkwall.util.SharedPreference;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterFriends extends RecyclerView.Adapter<AdapterFriends.FriendsViewHolder> {
    public static String USER_IDS = "USER_IDS";
    public static String TOKEN = "TOKEN";
    private FriendsViewHolder friendsViewHolder;
    private List<ItemFriends> itemFriends;

    public AdapterFriends(List<ItemFriends> itemFriends) {
        this.itemFriends = itemFriends;
    }

    @NonNull
    @Override
    public AdapterFriends.FriendsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.item_list_friends, viewGroup, false);
        friendsViewHolder = new FriendsViewHolder(itemView);
        return friendsViewHolder;
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onBindViewHolder(@NonNull AdapterFriends.FriendsViewHolder friendsViewHolder, int position) {
        ItemFriends friends = itemFriends.get(position);
        setData(friendsViewHolder, friends);
    }

    @Override
    public int getItemCount() {
        return itemFriends.size();
    }

    class FriendsViewHolder extends RecyclerView.ViewHolder {
        private TextView last_name, first_name;
        private ImageView photo_avatar, online;


        FriendsViewHolder(@NonNull final View itemView) {
            super(itemView);
            last_name = itemView.findViewById(R.id.last_name);
            first_name = itemView.findViewById(R.id.first_name);
            photo_avatar = itemView.findViewById(R.id.photo_avatar);
            online = itemView.findViewById(R.id.online);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), FriendsInfoActivity.class);
                    intent.putExtra(USER_IDS, itemFriends.get(getAdapterPosition()).getId() + "");
                    intent.putExtra(TOKEN, SharedPreference.loadToken(itemView.getContext()));
                    view.getContext().startActivity(intent);
                }
            });
        }
    }

    private void setData(FriendsViewHolder friendsViewHolder, ItemFriends friends) {
        friendsViewHolder.last_name.setText(friends.getLastName());
        friendsViewHolder.first_name.setText(friends.getFirstName());
        Picasso.with(friendsViewHolder.itemView.getContext())
                .load(friends.getPhotoMaxOrig())
                .into(friendsViewHolder.photo_avatar);
        if (friends.getOnline() == 1) {
            friendsViewHolder.online.setVisibility(View.VISIBLE);
        } else {
            friendsViewHolder.online.setVisibility(View.GONE);
        }
    }
}
