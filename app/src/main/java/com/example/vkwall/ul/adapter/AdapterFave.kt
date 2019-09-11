package com.example.vkwall.ul.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import com.example.vkwall.R
import com.example.vkwall.data.model.Profile.FaveProfile.GroupFave
import com.example.vkwall.data.model.Profile.FaveProfile.ItemFave
import com.example.vkwall.data.model.Profile.FaveProfile.ProfileFave
import com.example.vkwall.mvp.favedelete.FaveDeletePresenter
import com.example.vkwall.mvp.favedelete.FaveDeleteView
import com.example.vkwall.ul.App
import com.example.vkwall.util.SharedPreference
import com.squareup.picasso.Picasso
import kotlin.collections.forEach as forEach1

class AdapterFave : RecyclerView.Adapter<AdapterFave.ViewHolderFave>(), FaveDeleteView {

    private var presenter: FaveDeletePresenter? = null

    private var viewHolderFave: ViewHolderFave? = null

    private lateinit var itemFaves: List<ItemFave>
    private lateinit var profileFaves: List<ProfileFave>
    private lateinit var groupFaves: List<GroupFave>

    fun AdapterFave(itemFaves: List<ItemFave>, profileFaves: List<ProfileFave>, groupFaves: List<GroupFave>) {
        this.itemFaves = itemFaves
        this.profileFaves = profileFaves
        this.groupFaves = groupFaves
    }

    private var owner_id: Int = 0
    private var post_id: Int = 0

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolderFave {
        val itemView = LayoutInflater
                .from(viewGroup.context)
                .inflate(R.layout.item_list_fave, viewGroup, false)
        viewHolderFave = ViewHolderFave(itemView)
        return viewHolderFave as ViewHolderFave
    }

    override fun onBindViewHolder(viewHolderFave: ViewHolderFave, position: Int) {
        val itemFave = itemFaves[position]
        viewHolderFave.bind(viewHolderFave, itemFave)
    }

    override fun getItemCount(): Int {
        return itemFaves.size
    }

    inner class ViewHolderFave(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private val last_name_fave: TextView
        private val photo_profile_fave: ImageView
        private val photo_fave: ImageView
        private val text_fave: TextView
        private val delete_fave: ImageView

        init {
            last_name_fave = itemView.findViewById(R.id.last_name_fave)
            photo_profile_fave = itemView.findViewById(R.id.photo_profile_fave)
            text_fave = itemView.findViewById(R.id.text_fave)
            photo_fave = itemView.findViewById(R.id.photo_fave)
            delete_fave = itemView.findViewById(R.id.delete_fave)
            delete_fave.setOnClickListener(this)

            presenter = FaveDeletePresenter((itemView.context.applicationContext as App).dataManager)
            presenter!!.attachView(this@AdapterFave)
        }

        override fun onClick(view: View) {
            onItemClick(view, adapterPosition)
        }

        @SuppressLint("SetTextI18n")
        fun bind(viewHolderFave: ViewHolderFave, itemFave: ItemFave) {

            post_id = itemFave.post?.id!!
            owner_id = itemFave.post?.ownerId!!

            viewHolderFave.text_fave.text = itemFave.post!!.text
            Picasso.with(viewHolderFave.itemView.context)
                    .load(itemFave.post?.attachments?.get(0)?.photo?.sizes?.get(3)?.url)
                    .into(viewHolderFave.photo_fave)

            for (group in groupFaves) {
                val group_id = "-" + group.id!!
                if (group_id == itemFave.post!!.ownerId!!.toString()) {
                    viewHolderFave.last_name_fave.text = group.name
                    Picasso.with(viewHolderFave.itemView.context)
                            .load(group.photo100)
                            .into(viewHolderFave.photo_profile_fave)
                }
            }

            for (profile in profileFaves) {
                if (profile.id == itemFave.post!!.ownerId) {
                    viewHolderFave.last_name_fave.text = profile.lastName + " " + profile.firstName
                    Picasso.with(viewHolderFave.itemView.context)
                            .load(profile.photo100)
                            .into(viewHolderFave.photo_profile_fave)
                }
            }
        }
    }

    private fun onItemClick(view: View, position: Int) {
        presenter!!.delete(owner_id, post_id, SharedPreference.loadToken(view.context), "5.101")
        Toast.makeText(viewHolderFave!!.itemView.context, "Запись удалено из закладки $position", Toast.LENGTH_SHORT).show()
        notifyItemChanged(position)
    }
}
