package com.example.vkwall.ul.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import com.example.vkwall.R
import com.example.vkwall.data.model.Search.ItemSearch
import com.squareup.picasso.Picasso

class AdapterSearch(private val searches: List<ItemSearch>) : RecyclerView.Adapter<AdapterSearch.ViewHolderSearch>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolderSearch {
        val inflate = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_list_search, viewGroup, false)
        return ViewHolderSearch(inflate)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolderSearch: ViewHolderSearch, position: Int) {
        val item = searches[position]
        if (item.type == "profile") {
            Picasso.get().load(item.profile?.photo50).into(viewHolderSearch.avatars)
            viewHolderSearch.name.text = item.profile?.firstName + " " + item.profile?.lastName
        }
        if (item.type == "group") {
            Picasso.get().load(item.group?.photo50).into(viewHolderSearch.avatars)
            viewHolderSearch.name.text = item.group?.name
        }
        if (item.type == "vk_app") {
            Picasso.get().load(item.app?.icon139).into(viewHolderSearch.avatars)
            viewHolderSearch.name.text = item.app?.title
        }
    }

    override fun getItemCount(): Int {
        return searches.size
    }

    inner class ViewHolderSearch(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name: TextView
        val avatars: ImageView

        init {
            name = itemView.findViewById(R.id.name)
            avatars = itemView.findViewById(R.id.avatars)

            itemView.setOnClickListener {

            }
        }
    }
}
