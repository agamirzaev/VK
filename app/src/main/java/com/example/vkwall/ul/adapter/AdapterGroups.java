package com.example.vkwall.ul.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vkwall.R;
import com.example.vkwall.data.model.Profile.GroupProfile.ItemGroup;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterGroups extends RecyclerView.Adapter<AdapterGroups.ViewHolderGroups> {

    private List<ItemGroup> itemGroups;
    private ViewHolderGroups ViewHolderGroups;

    public AdapterGroups(List<ItemGroup> itemGroups) {
        this.itemGroups = itemGroups;
    }

    @NonNull
    @Override
    public AdapterGroups.ViewHolderGroups onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.item_list_groups, viewGroup, false);
        ViewHolderGroups = new ViewHolderGroups(itemView);
        return ViewHolderGroups;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterGroups.ViewHolderGroups viewHolder, int i) {
        ItemGroup itemGroup = itemGroups.get(i);
        viewHolder.name_groups.setText(itemGroup.getName());
        Picasso.with(viewHolder.itemView.getContext()).load(itemGroup.getPhoto100()).into(viewHolder.photo_groups);
    }

    @Override
    public int getItemCount() {
        return itemGroups.size();
    }

    class ViewHolderGroups extends RecyclerView.ViewHolder {
        private TextView name_groups;
        private ImageView photo_groups;

        ViewHolderGroups(@NonNull View itemView) {
            super(itemView);
            name_groups = itemView.findViewById(R.id.name_groups);
            photo_groups = itemView.findViewById(R.id.photo_groups);
        }
    }
}
