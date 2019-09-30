package com.example.vkwall.ul.adapter

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast

import com.example.vkwall.R
import com.example.vkwall.data.model.LikeWalls.ResponseLike
import com.example.vkwall.data.model.ProfileWall.Wall.GroupWall
import com.example.vkwall.data.model.ProfileWall.Wall.ItemWall
import com.example.vkwall.data.model.ProfileWall.Wall.ProfileWall
import com.example.vkwall.mvp.fave.FaveContract
import com.example.vkwall.mvp.fave.FavePresenter
import com.example.vkwall.mvp.favedelete.FaveDeletePresenter
import com.example.vkwall.mvp.favedelete.FaveDeleteView
import com.example.vkwall.mvp.likepost.LikeContract
import com.example.vkwall.mvp.likepost.LikePresenter
import com.example.vkwall.mvp.usersinfo.DeleteWallPresenter
import com.example.vkwall.mvp.usersinfo.DeleteWallView
import com.example.vkwall.ul.App
import com.example.vkwall.ul.main.activity.WallActivity
import com.example.vkwall.util.SharedPreference
import com.squareup.picasso.Picasso

class AdapterWall(private val itemWalls: List<ItemWall>, private val profileWalls: List<ProfileWall>, private val groupWalls: List<GroupWall>) : RecyclerView.Adapter<AdapterWall.ViewHolderWall>() {

    companion object {
        private const val POSTS = "POSTS"
        private const val POST_ID = "POST_ID"
        private const val OWNER_ID = "OWNER_ID"
        private const val TOKEN = "TOKEN"
    }

    private lateinit var alertDialog: AlertDialog

    private var deletePresenter: FaveDeletePresenter? = null
    private var presenter: LikePresenter? = null
    private var deleteWallpresenter: DeleteWallPresenter? = null


    private var viewHolderWall: ViewHolderWall? = null
    private var popupMenu: PopupMenu? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolderWall {
        val view = LayoutInflater
                .from(viewGroup.context)
                .inflate(R.layout.item_list_profile_wall, viewGroup, false)
        viewHolderWall = ViewHolderWall(view)
        return viewHolderWall as ViewHolderWall
    }

    override fun onBindViewHolder(viewHolderWall: ViewHolderWall, position: Int) {
        val itemWall = itemWalls[position]
        setData(viewHolderWall, itemWall)
    }


    override fun getItemCount(): Int {
        return itemWalls.size
    }

    inner class ViewHolderWall(itemView: View) : RecyclerView.ViewHolder(itemView),
            LikeContract.ViewLikePost, FaveDeleteView, DeleteWallView {

        override fun dialog(alertDialog: AlertDialog) {

        }

        val last_name: TextView
        val photo_profile: ImageView

        val groups: RelativeLayout
        val photo_groups: ImageView
        val name_groups: TextView

        val photo_wall: ImageView
        val text_wall: TextView

        val like_wall: ImageView

        val view_wall_count: TextView
        val like_wall_count: TextView
        val comments_wall_count: TextView
        private val comment_wall: ImageView

        val wall_option: TextView


        init {

            deleteWallpresenter = DeleteWallPresenter((itemView.context.applicationContext as App).dataManager!!)
            deleteWallpresenter!!.attachView(this)


            presenter = LikePresenter((itemView.context.applicationContext as App).dataManager)
            presenter!!.attachView(this)

            deletePresenter = FaveDeletePresenter((itemView.context.applicationContext as App).dataManager)
            deletePresenter!!.attachView(this)


            last_name = itemView.findViewById(R.id.last_name)
            photo_profile = itemView.findViewById(R.id.photo_profile)
            photo_wall = itemView.findViewById(R.id.photo_wall)
            text_wall = itemView.findViewById(R.id.text_wall)

            like_wall = itemView.findViewById(R.id.like_wall)

            groups = itemView.findViewById(R.id.groups)
            photo_groups = itemView.findViewById(R.id.photo_groups)
            name_groups = itemView.findViewById(R.id.name_groups)

            view_wall_count = itemView.findViewById(R.id.views_wall_count)
            like_wall_count = itemView.findViewById(R.id.like_wall_count)
            comments_wall_count = itemView.findViewById(R.id.comment_wall_count)
            comment_wall = itemView.findViewById(R.id.comment_wall)

            wall_option = itemView.findViewById(R.id.wall_option)


            comment_wall.setOnClickListener {
                val intent = Intent(itemView.context, WallActivity::class.java)
                intent.putExtra(POSTS, itemWalls[adapterPosition].ownerId.toString() + "_" + itemWalls[adapterPosition].id)
                intent.putExtra(POST_ID, itemWalls[adapterPosition].id!!.toString())
                intent.putExtra(OWNER_ID, itemWalls[adapterPosition].ownerId!!.toString())
                intent.putExtra(TOKEN, SharedPreference.loadToken(itemView.context))
                itemView.context.startActivity(intent)
            }
        }

        override fun showLike(responseLike: ResponseLike) {
            if (responseLike.likes == 1) {
                Toast.makeText(viewHolderWall!!.itemView.context, "Лайк поставлен", Toast.LENGTH_SHORT).show()
            }
        }

        override fun deleteLike(responseLike: ResponseLike) {
            if (responseLike.likes == 1) {
                Toast.makeText(viewHolderWall!!.itemView.context, "Лайк удалён", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setData(viewHolderWall: ViewHolderWall, itemWall: ItemWall) {

        val owner_id = itemWall.ownerId!!
        val item_id = itemWall.id!!

        viewHolderWall.wall_option.setOnClickListener { view ->
            popupMenu = PopupMenu(viewHolderWall.itemView.context, viewHolderWall.wall_option)
            popupMenu!!.inflate(R.menu.option_menu)
            popupMenu!!.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.add_bookmark ->
                        if (itemWall.isFavorite == false) {
                            deletePresenter!!.addFavePost(owner_id, item_id, SharedPreference.loadToken(viewHolderWall.itemView.context), "5.101")
                            Snackbar.make(view, "Сохранён в закладки ", Snackbar.LENGTH_LONG).show()
                        } else {
                            deletePresenter!!.delete(owner_id, item_id, SharedPreference.loadToken(viewHolderWall.itemView.context), "5.101")
                            Snackbar.make(view, "Удалён из закладки", Snackbar.LENGTH_LONG).show()
                        }
                    R.id.pin_bookmark ->
                        deleteWallpresenter!!.deleteWall(owner_id, item_id, SharedPreference.loadToken(viewHolderWall.itemView.context), "5.101")
                    R.id.copy_wall -> Snackbar.make(view, "Ссылка скопирована ", Snackbar.LENGTH_LONG).show()
                    R.id.delete_wall -> Snackbar.make(view, "Запись удалена ", Snackbar.LENGTH_LONG).show()
                }
                false
            }
            popupMenu!!.show()
        }

        for (profile in profileWalls) {
            if (profile.id == itemWall.ownerId) {
                viewHolderWall.last_name.text = profile.lastName + " " + profile.firstName
                Picasso.get()
                        .load(profile.photoMaxOrig)
                        .into(viewHolderWall.photo_profile)
            }
        }

        for (group in groupWalls) {
            viewHolderWall.groups.visibility = View.VISIBLE
            val owners_id = "-" + group.id!!
            if (itemWall.copyHistory != null) {
                if (owners_id == itemWall.copyHistory[0].ownerId!!.toString()) {
                    viewHolderWall.name_groups.text = group.name
                    Picasso.get()
                            .load(group.photo50)
                            .into(viewHolderWall.photo_groups)
                }
            } else {
                viewHolderWall.groups.visibility = View.GONE
            }
        }

        if (itemWall.views != null && itemWall.likes != null && itemWall.comments != null) {
            viewHolderWall.view_wall_count.text = itemWall.views.count!!.toString()
            viewHolderWall.like_wall_count.text = itemWall.likes.count!!.toString()
            viewHolderWall.comments_wall_count.text = itemWall.comments.count!!.toString()
        }


        if (itemWall.text != "") {
            viewHolderWall.text_wall.text = itemWall.text
        } else {
            viewHolderWall.text_wall.visibility = View.GONE
        }

        if (itemWall.attachments != null) {

            if (itemWall.attachments[0].type == "photo") {
                Picasso.get()
                        .load(itemWall.attachments[0].photo.sizes[4].url)
                        .into(viewHolderWall.photo_wall)
            }

            if (itemWall.attachments[0].type == "audio") {
                viewHolderWall.text_wall.visibility = View.VISIBLE
                viewHolderWall.text_wall.text = itemWall.attachments[0].audio.title
            }
        }

        if (itemWall.copyHistory != null) {
            viewHolderWall.text_wall.text = itemWall.copyHistory[0].text

            Picasso.get()
                    .load(itemWall.copyHistory[0].attachments[0].photo.sizes[4].url)
                    .into(viewHolderWall.photo_wall)
        }

        if (itemWall.likes.userLikes == 1) {
            viewHolderWall.like_wall.setImageResource(R.drawable.ic_like_true)
        } else {
            viewHolderWall.like_wall.setOnClickListener {
                Toast.makeText(viewHolderWall.itemView.context, "Вам понравилась", Toast.LENGTH_LONG).show()
                presenter!!.likePostWall("post", owner_id, item_id, SharedPreference.loadToken(viewHolderWall.itemView.context), "5.101")
                viewHolderWall.like_wall.setImageResource(R.drawable.ic_like_true)
            }
        }
    }
}
