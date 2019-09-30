package com.example.vkwall.ul.main.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

import com.example.vkwall.R
import com.example.vkwall.data.model.Profile.FaveProfile.GroupFave
import com.example.vkwall.data.model.Profile.FaveProfile.ItemFave
import com.example.vkwall.data.model.Profile.FaveProfile.ProfileFave
import com.example.vkwall.mvp.fave.FaveContract
import com.example.vkwall.mvp.fave.FavePresenter
import com.example.vkwall.mvp.favedelete.FaveDeletePresenter
import com.example.vkwall.mvp.favedelete.FaveDeleteView
import com.example.vkwall.ul.App
import com.example.vkwall.ul.adapter.AdapterFave
import com.example.vkwall.util.Constant
import com.example.vkwall.util.SharedPreference

class FaveActivity : AppCompatActivity(), FaveContract {
    private var favePresenter: FavePresenter? = null

    private var adapterFave: AdapterFave = AdapterFave()
    private var recyclerView: RecyclerView? = null
    private var layoutManager: LinearLayoutManager? = null
    private var dividerItemDecoration: DividerItemDecoration? = null

    private var toolbar: Toolbar? = null

    private var progressBar: ProgressBar? = null
    private var noInternet: TextView? = null

    private var now_fave: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fave)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Закладки"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        recyclerView = findViewById(R.id.recycler_fave)
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView!!.layoutManager = layoutManager
        dividerItemDecoration = DividerItemDecoration(recyclerView!!.context,
                layoutManager!!.orientation)
        recyclerView!!.addItemDecoration(dividerItemDecoration!!)

        progressBar = findViewById(R.id.progress_fave)
        noInternet = findViewById(R.id.no_internet_fave)

        now_fave = findViewById(R.id.now_fave)

        favePresenter = FavePresenter((application as App).dataManager)
        favePresenter!!.attachView(this)
        favePresenter!!.loadFaveProfile(SharedPreference.loadToken(this), 1, "photo_100", "post", Constant.VERSION)
    }

    override fun showFaveProfile(itemFave: ArrayList<ItemFave>, profileFaves: ArrayList<ProfileFave>, groupFaves: ArrayList<GroupFave>) {
        adapterFave.AdapterFave(itemFave, profileFaves, groupFaves)
        recyclerView?.adapter = adapterFave
        if (adapterFave.itemCount > 0) {
            now_fave?.visibility = View.GONE
        }
    }

    override fun showProgressFave() {
        progressBar!!.visibility = View.VISIBLE
        now_fave?.visibility = View.GONE
    }

    override fun hideProgressFave() {
        progressBar!!.visibility = View.GONE
        now_fave?.visibility = View.VISIBLE
    }

    override fun noInternetFave() {
        noInternet!!.visibility = View.VISIBLE
        now_fave?.visibility = View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        favePresenter?.detachView()
    }
}
