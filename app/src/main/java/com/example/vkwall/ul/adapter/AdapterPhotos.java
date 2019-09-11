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

public class AdapterPhotos extends RecyclerView.Adapter<AdapterPhotos.ViewHolderPhotos> {

    private List<ItemPhotos> itemPhotos;
    private ViewHolderPhotos viewHolderPhotos;

    public AdapterPhotos(List<ItemPhotos> itemPhotos) {
        this.itemPhotos = itemPhotos;
    }

    @NonNull
    @Override
    public AdapterPhotos.ViewHolderPhotos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.item_list_photo, viewGroup, false);
        viewHolderPhotos = new ViewHolderPhotos(itemView);
        return viewHolderPhotos;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPhotos.ViewHolderPhotos viewHolderPhotos, int i) {
        ItemPhotos itemPhoto = itemPhotos.get(i);
        Picasso.with(viewHolderPhotos.itemView.getContext())
                .load(itemPhoto.getSizes().get(3).getUrl())
                .into(viewHolderPhotos.list_photos);
    }

    @Override
    public int getItemCount() {
        return itemPhotos.size();
    }

    class ViewHolderPhotos extends RecyclerView.ViewHolder {
        private ImageView list_photos;

        ViewHolderPhotos(@NonNull View itemView) {
            super(itemView);

            list_photos = itemView.findViewById(R.id.list_photos);
        }
    }
}
