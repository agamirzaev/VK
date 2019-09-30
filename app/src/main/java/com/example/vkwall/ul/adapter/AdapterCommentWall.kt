package com.example.vkwall.ul.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.vkwall.R
import com.example.vkwall.data.model.ProfileWall.Comments.Groups
import com.example.vkwall.data.model.ProfileWall.Comments.Item
import com.example.vkwall.data.model.ProfileWall.Comments.Profile
import com.squareup.picasso.Picasso

class AdapterCommentWall : RecyclerView.Adapter<AdapterCommentWall.ViewHolderComment> {

    private lateinit var viewHolderComment: ViewHolderComment

    private var item: List<Item>
    private var profile: List<Profile>
    private val groups: List<Groups>

    constructor(item: List<Item>, profile: List<Profile>, groups: List<Groups>) {
        this.item = item
        this.profile = profile
        this.groups = groups
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolderComment {
        val itemView = LayoutInflater
                .from(viewGroup.context)
                .inflate(R.layout.item_comments_wall, viewGroup, false)
        viewHolderComment = ViewHolderComment(itemView)
        return viewHolderComment
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(viewHolderComment: ViewHolderComment, position: Int) {
        val items = item[position]
        viewHolderComment.bind(viewHolderComment, items)
    }

    inner class ViewHolderComment(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val photo_profile_com: ImageView
        private val comments_icons: ImageView
        private val name_profile_com: TextView
        private val comments: TextView

        init {
            photo_profile_com = itemView.findViewById(R.id.photo_profile_com)
            name_profile_com = itemView.findViewById(R.id.name_profile_com)
            comments = itemView.findViewById(R.id.comments)
            comments_icons = itemView.findViewById(R.id.comments_icons)
        }

        @SuppressLint("SetTextI18n")
        fun bind(viewHolder: ViewHolderComment, item: Item) {
            for (profiles in profile) {
                if (profiles.id == item.fromId) {
                    viewHolder.name_profile_com.text = profiles.firstName + " " + profiles.lastName
                    Picasso.get().load(profiles.photo100).into(viewHolder.photo_profile_com)
                }
            }

            for (groups in groups) {
                val id = "-" + groups.id
                if (id == item.fromId.toString()) {
                    viewHolder.name_profile_com.text = groups.name
                    Picasso.get().load(groups.photo100).into(viewHolder.photo_profile_com)
                }
            }

            viewHolder.comments.text = item.text
            if (item.attachments != null) {
                Picasso.get().load(item.attachments!![0].sticker?.images?.get(0)?.url).into(viewHolder.comments_icons)
            }
        }
    }
}