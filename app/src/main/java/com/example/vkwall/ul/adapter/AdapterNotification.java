package com.example.vkwall.ul.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vkwall.R;
import com.example.vkwall.data.model.Notification.ItemNotif;
import com.example.vkwall.data.model.Notification.ProfileNotif;
import com.squareup.picasso.Picasso;


import java.util.List;

public class AdapterNotification extends RecyclerView.Adapter<AdapterNotification.ViewHolderNotification> {

    private ViewHolderNotification viewHolderNotification;
    private List<ItemNotif> itemNotifs;
    private List<ProfileNotif> profileNotifs;

    public AdapterNotification(List<ItemNotif> itemNotifs, List<ProfileNotif> profileNotifs) {
        this.itemNotifs = itemNotifs;
        this.profileNotifs = profileNotifs;
    }

    @NonNull
    @Override
    public AdapterNotification.ViewHolderNotification onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.item_list_notification, viewGroup, false);
        viewHolderNotification = new ViewHolderNotification(itemView);
        return viewHolderNotification;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AdapterNotification.ViewHolderNotification viewHolderNotification, int position) {
        ItemNotif itemNotif = itemNotifs.get(position);


        if (itemNotif.getParent().getAttachments() != null) {
            viewHolderNotification.comments.setText("Оставил(-ла) комментарий \n" + itemNotif.getFeedback().getText());
            Picasso.with(viewHolderNotification.itemView.getContext())
                    .load(itemNotif.getParent().getAttachments().get(0).getPhoto().getSizes().get(3).getUrl())
                    .into(viewHolderNotification.photo);
        }


        for (ProfileNotif profile : profileNotifs) {
            if (profile.getId().equals(itemNotif.getFeedback().getFromId())) {
                viewHolderNotification.name_profile.setText(
                        profile.getLastName() + " " + profile.getFirstName()
                );
                Picasso.with(viewHolderNotification.itemView.getContext())
                        .load(profile.getPhoto100())
                        .into(viewHolderNotification.photo_profile);
            }

//            if (itemNotif.getFeedback().getItems() != null) {
//                if (profile.getId().equals(itemNotif.getFeedback().getItems().get(position).getFromId())) {
//                    viewHolderNotification.comments.setText("Оценил(-ла) вашу запись");
//                    Picasso.with(viewHolderNotification.itemView.getContext())
//                            .load(itemNotif.getParent().getAttachments().get(0).getPhoto().getSizes().get(3).getUrl())
//                            .into(viewHolderNotification.photo);
//                }
//            }
        }

    }

    @Override
    public int getItemCount() {
        return itemNotifs.size();
    }

    class ViewHolderNotification extends RecyclerView.ViewHolder {
        private ImageView photo_profile;
        private ImageView photo;
        private TextView name_profile;
        private TextView comments;

        ViewHolderNotification(@NonNull View itemView) {
            super(itemView);

            photo = itemView.findViewById(R.id.photo);
            photo_profile = itemView.findViewById(R.id.photo_profile);
            name_profile = itemView.findViewById(R.id.name_profile);
            comments = itemView.findViewById(R.id.comments);

        }
    }
}
