package com.example.vkwall.ul.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vkwall.R;
import com.example.vkwall.data.model.Profile.DocsProfile.ItemDocs;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterDocs extends RecyclerView.Adapter<AdapterDocs.ViewHolderDocs> {

    private ViewHolderDocs viewHolderDocs;
    private List<ItemDocs> itemDocs;

    public AdapterDocs(List<ItemDocs> itemDocs) {
        this.itemDocs = itemDocs;
    }

    @NonNull
    @Override
    public AdapterDocs.ViewHolderDocs onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.item_list_docs, viewGroup, false);
        viewHolderDocs = new ViewHolderDocs(itemView);
        return viewHolderDocs;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDocs.ViewHolderDocs viewHolderDocs, int i) {
        ItemDocs item = itemDocs.get(i);
        viewHolderDocs.name_docs.setText(item.getTitle());
        Picasso.with(viewHolderDocs.itemView.getContext()).load(item.getUrl()).into(viewHolderDocs.image_docs);
    }

    @Override
    public int getItemCount() {
        return itemDocs.size();
    }

    class ViewHolderDocs extends RecyclerView.ViewHolder {
        private ImageView image_docs;
        private TextView name_docs;

        ViewHolderDocs(@NonNull View itemView) {
            super(itemView);
            image_docs = itemView.findViewById(R.id.image_docs);
            name_docs = itemView.findViewById(R.id.name_docs);
        }
    }
}
