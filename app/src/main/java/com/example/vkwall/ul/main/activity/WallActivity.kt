package com.example.vkwall.ul.main.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.example.vkwall.R
import com.example.vkwall.data.model.GetWallByID.GroupById
import com.example.vkwall.data.model.GetWallByID.ItemById
import com.example.vkwall.data.model.GetWallByID.ProfileById
import com.example.vkwall.data.model.LikeWalls.ResponseLike
import com.example.vkwall.data.model.ProfileWall.Comments.Groups
import com.example.vkwall.data.model.ProfileWall.Comments.Item
import com.example.vkwall.data.model.ProfileWall.Comments.Profile
import com.example.vkwall.mvp.comments.CommentsPresenter
import com.example.vkwall.mvp.comments.CommentsView
import com.example.vkwall.mvp.favedelete.FaveDeletePresenter
import com.example.vkwall.mvp.favedelete.FaveDeleteView
import com.example.vkwall.mvp.friendswall.FriendsWallContract
import com.example.vkwall.mvp.friendswall.FriendsWallPresenter
import com.example.vkwall.mvp.likepost.LikeContract
import com.example.vkwall.mvp.likepost.LikePresenter
import com.example.vkwall.ul.App
import com.example.vkwall.ul.adapter.AdapterCommentWall
import com.example.vkwall.ul.adapter.AdapterFriendsWall
import com.example.vkwall.util.Constant
import com.squareup.picasso.Picasso

class WallActivity : AppCompatActivity(), FriendsWallContract.ViewFriendsWall, LikeContract.ViewLikePost, CommentsView, FaveDeleteView {

    companion object {
        private const val FIELDS = "photo_max_orig,status,city,home_town,photo_50,photo_100"
        private const val VERSION = "5.101"
        private const val EXTENDED = 1
        private const val FILTER = "owner"
    }

    private lateinit var toolbar: Toolbar

    private lateinit var posts: String
    private lateinit var token: String
    private lateinit var post_id: String
    private lateinit var owner_id: String

    private var adapterCommentWall: AdapterCommentWall? = null
    private var recyclerView: RecyclerView? = null
    private var layoutManager: LinearLayoutManager? = null
    private var dividerItemDecoration: DividerItemDecoration? = null

    private var presenterDeleteView: FaveDeletePresenter? = null

    private var presenter: FriendsWallPresenter? = null
    private var likePresenter: LikePresenter? = null
    private var commentsPresenter: CommentsPresenter? = null

    private var last_name: TextView? = null
    private var first_name: TextView? = null
    private var imageView: ImageView? = null

    private var groups: LinearLayout? = null
    private var likes: LinearLayout? = null
    private var photo_groups: ImageView? = null
    private var name_groups: TextView? = null

    private var count_like_walls: TextView? = null
    private var count_views_walls: TextView? = null

    private var progressBarWall: ProgressBar? = null
    private var noInternet: TextView? = null

    private var comment_can_post: TextView? = null

    private var text_wall: TextView? = null
    private var photo_walls: ImageView? = null

    private var like_walls: ImageView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wall)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Запись на стене"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        recyclerView = findViewById(R.id.recycler_view_wall)
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.layoutManager = layoutManager
        dividerItemDecoration = DividerItemDecoration(recyclerView!!.context,
                layoutManager!!.orientation)
        recyclerView!!.addItemDecoration(dividerItemDecoration!!)

        initialLayout()
        getStringExtra()
        initialPresenter()
    }

    private fun initialLayout() {
        last_name = findViewById(R.id.last_name)
        first_name = findViewById(R.id.first_name)
        imageView = findViewById(R.id.photo_profiles)
        text_wall = findViewById(R.id.text_wall)
        photo_walls = findViewById(R.id.photo_walls)

        like_walls = findViewById(R.id.like_walls)

        likes = findViewById(R.id.likes)
        progressBarWall = findViewById(R.id.progress_bar_wall)
        noInternet = findViewById(R.id.no_internet_wall)

        groups = findViewById(R.id.groups)
        photo_groups = findViewById(R.id.photo_groups)
        name_groups = findViewById(R.id.name_groups)

        count_like_walls = findViewById(R.id.count_like_walls)
        count_views_walls = findViewById(R.id.count_views_walls)
        comment_can_post = findViewById(R.id.comment_can_post)
    }

    private fun getStringExtra() {
        posts = intent.getStringExtra(AdapterFriendsWall.POSTS)
        token = intent.getStringExtra(AdapterFriendsWall.TOKEN)
        owner_id = intent.getStringExtra(AdapterFriendsWall.OWNER_ID)
        post_id = intent.getStringExtra(AdapterFriendsWall.POST_ID)
    }


    private fun initialPresenter() {
        likePresenter = LikePresenter((application as App).dataManager)
        likePresenter!!.attachView(this@WallActivity)

        commentsPresenter = CommentsPresenter((application as App).dataManager!!)
        commentsPresenter!!.attachView(this@WallActivity)

        presenter = FriendsWallPresenter((application as App).dataManager)
        presenter!!.attachView(this@WallActivity)
        presenter!!.loadFriendsWall(posts, EXTENDED, FIELDS, FILTER, token, VERSION)

        presenterDeleteView = FaveDeletePresenter((application as App).dataManager!!)
        presenterDeleteView!!.attachView(this@WallActivity)
    }

    override fun onDestroy() {
        super.onDestroy()
        likePresenter!!.detachView()
        commentsPresenter!!.detachView()
        presenter!!.detachView()
        presenterDeleteView!!.detachView()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_saved, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.add_bookmark -> {
                presenterDeleteView!!.addFavePost(owner_id.toInt(), post_id.toInt(), token, Constant.VERSION)
                Toast.makeText(this, "Добавлена в закладки", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


    @SuppressLint("SetTextI18n")
    override fun showFriendsWall(itemByIds: List<ItemById>, profileByIds: List<ProfileById>, groupByIds: List<GroupById>) {

        for (items in itemByIds) {
            likes!!.visibility = View.VISIBLE
            for (profileById in profileByIds) {
                last_name!!.text = profileById.lastName
                first_name!!.text = profileById.firstName
                Picasso.get()
                        .load(profileById.photo100)
                        .into(imageView)
            }

            for (groupById in groupByIds) {
                groups!!.visibility = View.VISIBLE
                val owner_id = "-" + groupById.id!!
                if (items.copyHistoryWalls != null) {
                    if (owner_id == items.copyHistoryWalls!![0].ownerId!!.toString() + "") {
                        name_groups!!.text = groupById.name
                        Picasso.get().load(groupById.photo100).into(photo_groups)
                    }
                } else {
                    groups!!.visibility = View.GONE
                }

            }
            setDataWall(items)
        }
    }

    private fun setDataWall(items: ItemById) {
        if (items.likes != null && items.views != null) {
            count_like_walls!!.text = items.likes?.count.toString()
            count_views_walls!!.text = items.views?.count.toString()
        }

        if (items.text != "") {
            text_wall!!.text = items.text
        } else {
            text_wall!!.visibility = View.GONE
        }


        if (items.attachments != null) {
            if (items.attachments!![0].type == "audio") {
                text_wall!!.visibility = View.VISIBLE
                text_wall!!.text = items.attachments!![0].audio!!.title
            }

            if (items.attachments!![0].type == "photo") {
                Picasso.get()
                        .load(items.attachments!![0].photo?.sizes?.get(4)?.url)
                        .into(photo_walls)
            }
        }


        if (items.comments!!.canPost == 0) {
            comment_can_post!!.text = "Комментарии отключены"
        } else {
            commentsPresenter!!.loadCommentsWall(owner_id, post_id, 1, 20, token, VERSION)
        }

        if (items.copyHistoryWalls != null) {
            if (items.copyHistoryWalls!![0].text != "") {
                text_wall!!.text = items.copyHistoryWalls!![0].text
            }
            Picasso.get()
                    .load(items.copyHistoryWalls!![0].attachments?.get(0)?.photo?.sizes?.get(4)?.url)
                    .into(photo_walls)
        }

        if (items.likes!!.userLikes != 0) {
            like_walls!!.setImageDrawable(getDrawable(R.drawable.ic_like_true))
        } else {
            like_walls!!.setImageDrawable(getDrawable(R.drawable.ic_like))
        }

        if (items.likes!!.userLikes == 1) {
            like_walls!!.setOnClickListener {
                likePresenter!!.deleteLike("post", owner_id.toInt(), post_id.toInt(), token, VERSION)
                presenter!!.loadFriendsWall(posts, EXTENDED, FIELDS, FILTER, token, VERSION)
            }
        }

        if (items.likes!!.userLikes == 0) {
            like_walls!!.setOnClickListener {
                likePresenter!!.likePostWall("post", owner_id.toInt(), post_id.toInt(), token, VERSION)
                presenter!!.loadFriendsWall(posts, EXTENDED, FIELDS, FILTER, token, VERSION)
            }
        }
    }


    override fun showProgress() {
        progressBarWall!!.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBarWall!!.visibility = View.GONE
    }

    override fun noInternet() {
        noInternet!!.visibility = View.VISIBLE
    }

    @SuppressLint("SetTextI18n")
    override fun showLike(responseLike: ResponseLike) {
        like_walls!!.setImageDrawable(getDrawable(R.drawable.ic_like_true))
        count_like_walls!!.text = responseLike.likes!!.toString() + ""
    }

    @SuppressLint("SetTextI18n")
    override fun deleteLike(responseLike: ResponseLike) {
        like_walls!!.setImageDrawable(getDrawable(R.drawable.ic_like))
        count_like_walls!!.text = responseLike.likes!!.toString() + ""
    }

    override fun showComments(item: List<Item>, profile: List<Profile>, groups: List<Groups>) {
        adapterCommentWall = AdapterCommentWall(item, profile, groups)
        recyclerView!!.adapter = adapterCommentWall
    }

}
