package com.example.vkwall.ul.main.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import com.example.vkwall.R
import com.example.vkwall.data.model.Recommended.GroupRecommended
import com.example.vkwall.data.model.Recommended.ItemRecommended
import com.example.vkwall.data.model.Recommended.ProfileRecommended
import com.example.vkwall.data.model.Search.ItemSearch
import com.example.vkwall.mvp.recommended.RecommendedPresenter
import com.example.vkwall.mvp.recommended.RecommendedView
import com.example.vkwall.mvp.search.SearchPresenter
import com.example.vkwall.mvp.search.SearchView
import com.example.vkwall.ul.App
import com.example.vkwall.ul.adapter.AdapterRecommended
import com.example.vkwall.ul.adapter.AdapterSearch
import com.example.vkwall.util.SharedPreference


class SearchActivity : AppCompatActivity(), SearchView, RecommendedView {

    private lateinit var searchPresenter: SearchPresenter
    private lateinit var recommendedPresenter: RecommendedPresenter

    private lateinit var toolbar: Toolbar

    private lateinit var recommended: TextView

    private lateinit var searchView: android.widget.SearchView
    private lateinit var item: MenuItem

    private lateinit var recyclerViewSearch: RecyclerView
    private lateinit var recyclerViewRecommended: RecyclerView
    private lateinit var adapterRecommended: AdapterRecommended
    private lateinit var adapter: AdapterSearch
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var dividerItemDecoration: DividerItemDecoration

    private lateinit var progress_search: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Поиск"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerViewSearch = findViewById(R.id.search)
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerViewSearch.layoutManager = layoutManager
        dividerItemDecoration = DividerItemDecoration(recyclerViewSearch.context,
                layoutManager.orientation)
        recyclerViewSearch.addItemDecoration(dividerItemDecoration)

        recyclerViewRecommended = findViewById(R.id.recommended_recycler)
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerViewRecommended.layoutManager = layoutManager
        dividerItemDecoration = DividerItemDecoration(recyclerViewRecommended.context,
                layoutManager.orientation)
        recyclerViewRecommended.addItemDecoration(dividerItemDecoration)

        progress_search = findViewById(R.id.progress_search)

        recommended = findViewById(R.id.recommended)

        recommendedPresenter = RecommendedPresenter((application as App).dataManager)
        recommendedPresenter.attachView(this@SearchActivity)

        searchPresenter = SearchPresenter((application as App).dataManager)
        searchPresenter.attachView(this@SearchActivity)

    }

    override fun onStart() {
        super.onStart()
        recommendedPresenter.loadRecommended(SharedPreference.loadToken(this@SearchActivity), "5.101")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_search, menu)
        item = menu!!.findItem(R.id.item_search)
        searchView = item.actionView as android.widget.SearchView


        searchView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                searchView(newText)
                return true
            }
        })

        return super.onCreateOptionsMenu(menu)
    }

    fun searchView(search: String): String {
        if (search != "") {
            recommended.text = "Результат поиска"
            recyclerViewRecommended.visibility = View.GONE
            recyclerViewSearch.visibility = View.VISIBLE
            searchPresenter.loadSearch(search, "photo_50", 200, SharedPreference.loadToken(this@SearchActivity), "5.101")
        } else {
            recommended.text = "Рекомендации"
            recommendedPresenter.loadRecommended(SharedPreference.loadToken(this@SearchActivity), "5.101")
            recyclerViewSearch.visibility = View.GONE
        }
        return search
    }

    override fun search(item: List<ItemSearch>) {
        adapter = AdapterSearch(item)
        recyclerViewSearch.adapter = adapter
    }

    override fun getRecommended(itemRecommended: List<ItemRecommended>, profileRecommended: List<ProfileRecommended>, groupRecommended: List<GroupRecommended>) {
        recyclerViewRecommended.visibility = View.VISIBLE
        recommended.text = "Рекомендации"
        adapterRecommended = AdapterRecommended(itemRecommended, profileRecommended, groupRecommended)
        recyclerViewRecommended.adapter = adapterRecommended
    }

    override fun noInternet() {
    }

    override fun showProgress() {
        progress_search.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_search.visibility = View.GONE
    }
}
