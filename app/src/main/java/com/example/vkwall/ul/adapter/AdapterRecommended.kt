package com.example.vkwall.ul.adapter

import android.annotation.SuppressLint
import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.vkwall.R
import com.example.vkwall.data.model.Recommended.GroupRecommended
import com.example.vkwall.data.model.Recommended.ItemRecommended
import com.example.vkwall.data.model.Recommended.ProfileRecommended
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list_recommended.view.*

class AdapterRecommended : RecyclerView.Adapter<AdapterRecommended.ViewHolderRecommended> {
    private var itemRecommended: List<ItemRecommended>
    private var profileRecommended: List<ProfileRecommended>
    private var groupRecommended: List<GroupRecommended>

    constructor(itemRecommended: List<ItemRecommended>, profileRecommended: List<ProfileRecommended>, groupRecommended: List<GroupRecommended>) {
        this.itemRecommended = itemRecommended
        this.profileRecommended = profileRecommended
        this.groupRecommended = groupRecommended
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolderRecommended {
        val inflate = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_list_recommended, viewGroup, false)
        return ViewHolderRecommended(inflate)
    }

    override fun getItemCount(): Int {
        return itemRecommended.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolderRecommended, position: Int) {
        val item = itemRecommended[position]
        viewHolder.setData(viewHolder, item)
    }

    inner class ViewHolderRecommended(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var name_recommended: TextView
        private var avatar_recommended: ImageView
        private var photo_recommended: ImageView
        private var text_recommended: TextView

        init {
            name_recommended = itemView.findViewById(R.id.name_recommended)
            avatar_recommended = itemView.findViewById(R.id.avatar_recommended)
            photo_recommended = itemView.findViewById(R.id.photo_recommended)
            text_recommended = itemView.findViewById(R.id.text_recommended)
        }

        @SuppressLint("SetTextI18n")
        fun setData(viewHolder: ViewHolderRecommended, item: ItemRecommended) {
            for (profile in profileRecommended) {
                if (item.sourceId == profile.id) {
                    viewHolder.itemView.name_recommended.text = profile.lastName + " " + profile.firstName
                    Picasso.get().load(profile.photo50).into(viewHolder.itemView.avatar_recommended)
                }
            }
            for (group in groupRecommended) {
                val id = "-" + group.id
                if (id == item.sourceId.toString()) {
                    viewHolder.itemView.name_recommended.text = group.name
                    Picasso.get().load(group.photo50).into(viewHolder.itemView.avatar_recommended)
                }
            }

            if (item.type == "post") {

                if (item.text != "") {
                    viewHolder.text_recommended.text = item.text
                } else {
                    viewHolder.text_recommended.visibility = View.GONE
                }

                if (item.attachments!![0].type == "photo") {
                    Picasso.get().load(item.attachments!![0].photo?.sizes?.get(4)?.url).into(viewHolder.photo_recommended)
                }
            }
        }
    }
}