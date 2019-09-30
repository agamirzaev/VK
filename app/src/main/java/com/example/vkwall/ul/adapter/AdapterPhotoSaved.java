package com.example.vkwall.ul.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.vkwall.R;
import com.example.vkwall.data.model.Profile.PhotosProfile.ItemPhotos;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterPhotoSaved extends RecyclerView.Adapter<AdapterPhotoSaved.ViewHolder> {
    private ViewHolder viewHolder;
    private List<ItemPhotos> itemPhotos;

    public AdapterPhotoSaved(List<ItemPhotos> itemPhotos) {
        this.itemPhotos = itemPhotos;
    }

    @NonNull
    @Override
    public AdapterPhotoSaved.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.item_list_photo_saved, viewGroup, false);
        viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPhotoSaved.ViewHolder viewHolder, int i) {
        ItemPhotos item = itemPhotos.get(i);
        Picasso.get()
                .load(item.getSizes().get(3).getUrl())
                .into(viewHolder.list_photos);

    }

    @Override
    public int getItemCount() {
        return itemPhotos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView list_photos;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            list_photos = itemView.findViewById(R.id.list_photos);
        }
    }
}
