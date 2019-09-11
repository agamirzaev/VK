package com.example.vkwall.ul.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vkwall.R;
import com.example.vkwall.data.model.Profile.VideoProfile.ItemVideo;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdapterVideo extends RecyclerView.Adapter<AdapterVideo.ViewHolderVideo> {

    private ViewHolderVideo viewHolderVideo;
    private List<ItemVideo> itemVideos;

    public AdapterVideo(List<ItemVideo> itemVideos) {
        this.itemVideos = itemVideos;
    }

    @NonNull
    @Override
    public AdapterVideo.ViewHolderVideo onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.item_list_video, viewGroup, false);
        viewHolderVideo = new ViewHolderVideo(itemView);
        return viewHolderVideo;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AdapterVideo.ViewHolderVideo viewHolderVideo, int position) {
        ItemVideo itemVideo = itemVideos.get(position);
        setDate(viewHolderVideo, itemVideo);
    }

    private String getDate(String timeStampStr) {
        try {
            @SuppressLint("SimpleDateFormat")
            DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date netDate = (new Date(Long.parseLong(timeStampStr)));
            return sdf.format(netDate);
        } catch (Exception ignored) {
            return ignored.getMessage();
        }
    }

    @Override
    public int getItemCount() {
        return itemVideos.size();
    }

    class ViewHolderVideo extends RecyclerView.ViewHolder {
        private ImageView photo_video;
        private TextView name_video, view_video, data_video;

        ViewHolderVideo(@NonNull View itemView) {
            super(itemView);

            photo_video = itemView.findViewById(R.id.image_video);

            name_video = itemView.findViewById(R.id.name_video);
            view_video = itemView.findViewById(R.id.views_video);
            data_video = itemView.findViewById(R.id.data_video);

        }
    }

    @SuppressLint("SetTextI18n")
    private void setDate(ViewHolderVideo viewHolderVideo, ItemVideo itemVideo) {
        long timestamp = Long.parseLong("" + itemVideo.getDate()) * 1000L;
        viewHolderVideo.name_video.setText(itemVideo.getTitle());
        viewHolderVideo.view_video.setText("Просмотры " + itemVideo.getViews().toString());
        viewHolderVideo.data_video.setText(getDate(timestamp + ""));

        Picasso.with(viewHolderVideo.itemView.getContext())
                .load(itemVideo.getImage().get(3).getUrl())
                .into(viewHolderVideo.photo_video);
    }
}
