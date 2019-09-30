package com.example.vkwall.ul.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.example.vkwall.R
import com.example.vkwall.data.model.Profile.FaveProfile.FieldsFave

import com.example.vkwall.data.model.Profile.FaveProfile.GroupFave
import com.example.vkwall.data.model.Profile.FaveProfile.ItemFave
import com.example.vkwall.data.model.Profile.FaveProfile.ProfileFave
import com.example.vkwall.mvp.favedelete.FaveDeletePresenter
import com.example.vkwall.mvp.favedelete.FaveDeleteView
import com.example.vkwall.ul.App
import com.example.vkwall.ul.main.activity.WallActivity
import com.example.vkwall.util.Constant
import com.example.vkwall.util.SharedPreference
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_fave.view.*
import kotlinx.android.synthetic.main.item_list_fave.view.*


class AdapterFave : RecyclerView.Adapter<AdapterFave.ViewHolderFave>(), FaveDeleteView {

    companion object {
        const val POSTS: String = "POSTS"
        const val POST_ID: String = "POST_ID"
        const val OWNER_ID: String = "OWNER_ID"
        const val TOKEN: String = "TOKEN"
    }
    private var faveDeletePresenter: FaveDeletePresenter? = null

    private lateinit var viewHolderFave: ViewHolderFave

    private lateinit var itemFaves: ArrayList<ItemFave>
    private lateinit var profileFaves: ArrayList<ProfileFave>
    private lateinit var groupFaves: ArrayList<GroupFave>

    fun AdapterFave(itemFaves: ArrayList<ItemFave>, profileFaves: ArrayList<ProfileFave>, groupFaves: ArrayList<GroupFave>) {
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
        return viewHolderFave
    }

    override fun onBindViewHolder(viewHolderFave: ViewHolderFave, position: Int) {
        val itemFave = itemFaves[position]
        viewHolderFave.bind(viewHolderFave, itemFave)
    }

    override fun getItemCount(): Int {
        return itemFaves.size
    }

    inner class ViewHolderFave(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val last_name_fave: TextView
        private val photo_profile_fave: ImageView
        private val photo_fave: ImageView
        private val text_fave: TextView
        private val delete_fave: ImageView
        private val like_wall_count: TextView
        private val comment_wall: ImageView
        private val comment_wall_count: TextView
        private val views_wall_count: TextView

        init {
            last_name_fave = itemView.findViewById(R.id.last_name_fave)
            photo_profile_fave = itemView.findViewById(R.id.photo_profile_fave)
            text_fave = itemView.findViewById(R.id.text_fave)
            photo_fave = itemView.findViewById(R.id.photo_fave)
            delete_fave = itemView.findViewById(R.id.delete_fave)

            like_wall_count = itemView.findViewById(R.id.like_wall_count)
            views_wall_count = itemView.findViewById(R.id.views_wall_count)
            comment_wall_count = itemView.findViewById(R.id.comment_wall_count)

            comment_wall = itemView.findViewById(R.id.comment_wall)

            faveDeletePresenter = FaveDeletePresenter((itemView.context.applicationContext as App).dataManager)
            faveDeletePresenter!!.attachView(this@AdapterFave)
        }


        @SuppressLint("SetTextI18n")
        fun bind(viewFave: ViewHolderFave, itemFave: ItemFave) {

            post_id = itemFave.post?.id!!
            owner_id = itemFave.post?.ownerId!!

            if (itemFave.post!!.text != "") {
                viewFave.text_fave.text = itemFave.post!!.text
            } else {
                viewFave.text_fave.visibility = View.GONE
            }

            Picasso.get()
                    .load(itemFave.post?.attachments?.get(0)?.photo?.sizes?.get(3)?.url)
                    .into(viewFave.photo_fave)

            for (group in groupFaves) {
                val group_id = "-" + group.id!!
                if (group_id == itemFave.post!!.ownerId!!.toString()) {
                    viewFave.last_name_fave.text = group.name
                    Picasso.get()
                            .load(group.photo100)
                            .into(viewFave.photo_profile_fave)
                }
            }

            for (profile in profileFaves) {
                if (profile.id == itemFave.post!!.ownerId) {
                    viewFave.last_name_fave.text = profile.lastName + " " + profile.firstName
                    Picasso.get()
                            .load(profile.photo100)
                            .into(viewFave.photo_profile_fave)
                }
            }

            viewFave.comment_wall_count.text = itemFave.post!!.comments?.count.toString()
            viewFave.like_wall_count.text = itemFave.post!!.likes?.count.toString()
            viewFave.views_wall_count.text = itemFave.post!!.views?.count.toString()


//            comment_wall.setOnClickListener {
//                val intent = Intent(itemView.context, WallActivity::class.java)
//                intent.putExtra(POSTS, "" + owner_id + "_" + post_id)
//                intent.putExtra(POST_ID, itemFave.post!!.id)
//                intent.putExtra(OWNER_ID, itemFave.post!!.ownerId)
//                intent.putExtra(TOKEN, SharedPreference.loadToken(itemView.context))
//                itemView.context.startActivity(intent)
//            }

            viewFave.itemView.delete_fave.setOnClickListener {
                faveDeletePresenter!!.delete(owner_id, post_id, SharedPreference.loadToken(viewFave.itemView.context), Constant.VERSION)
                Toast.makeText(viewFave.itemView.context, "Запись удалена из закладок", Toast.LENGTH_SHORT).show()
                viewFave.removeItem(adapterPosition)
            }
        }

        private fun removeItem(position: Int) {
            itemFaves.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, itemFaves.size)
        }
    }

}

