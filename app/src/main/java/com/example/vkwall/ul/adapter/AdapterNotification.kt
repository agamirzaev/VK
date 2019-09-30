package com.example.vkwall.ul.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import com.example.vkwall.R
import com.example.vkwall.data.model.Notification.ItemNotif
import com.example.vkwall.data.model.Notification.ProfileNotif
import com.squareup.picasso.Picasso

class AdapterNotification(private val itemNotifs: List<ItemNotif>, private val profileNotifs: List<ProfileNotif>) : RecyclerView.Adapter<AdapterNotification.ViewHolderNotification>() {

    private var viewHolderNotification: ViewHolderNotification? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolderNotification {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_list_notification, viewGroup, false)
        viewHolderNotification = ViewHolderNotification(itemView)

        val itemView2 = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_list_notification, viewGroup, false)
        viewHolderNotification = ViewHolderNotification(itemView2)

        return viewHolderNotification as ViewHolderNotification
    }

    override fun onBindViewHolder(viewHolderNotification: ViewHolderNotification, position: Int) {
        val itemNotif = itemNotifs[position]
        bind(viewHolderNotification, itemNotif)
    }

    override fun getItemCount(): Int {
        return itemNotifs.size
    }

    inner class ViewHolderNotification(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo_profile: ImageView
        val photo: ImageView
        val name_profile: TextView
        val comments: TextView

        init {

            photo = itemView.findViewById(R.id.photo)
            photo_profile = itemView.findViewById(R.id.photo_profile)
            name_profile = itemView.findViewById(R.id.name_profile)
            comments = itemView.findViewById(R.id.comments)

        }

    }

    @SuppressLint("SetTextI18n")
    private fun bind(viewHolder: ViewHolderNotification, itemNotif: ItemNotif) {
        for (profile in profileNotifs) {
            if (profile.id == itemNotif.feedback.items[0].fromId) {
                viewHolder.name_profile.text = profile.lastName + " " + profile.firstName
                Picasso.get()
                        .load(profile.photo100)
                        .into(viewHolder.photo_profile)


                if (itemNotif.type == "friend_accepted") {
                    viewHolder.comments.text = "Принял(-ла) Вашу заявку в друзья"
                }
            }
        }
    }
}
