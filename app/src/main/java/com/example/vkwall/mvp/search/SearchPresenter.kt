package com.example.vkwall.mvp.search

import com.arellomobile.mvp.InjectViewState
import com.example.vkwall.data.DataManager
import com.example.vkwall.data.model.Search.FieldsSearch
import com.example.vkwall.mvp.base.BasePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@InjectViewState
class SearchPresenter : BasePresenter<SearchView> {
    private var dataManager: DataManager? = null

    private lateinit var callSearch: Call<FieldsSearch>

    constructor(dataManager: DataManager?) {
        this.dataManager = dataManager
    }

    fun loadSearch(q: String, fields: String, limit: Int, access_token: String, v: String) {
        view.showProgress()
        callSearch = dataManager!!.setSearch(q, fields, limit, access_token, v)
        callSearch.enqueue(object : Callback<FieldsSearch> {
            override fun onResponse(call: Call<FieldsSearch>, response: Response<FieldsSearch>) {
                if (view != null) {
                    view.hideProgress()
                    if (response.isSuccessful) {
                        view.search(response.body()!!.response!!.items!!)
                    }
                }
            }

            override fun onFailure(call: Call<FieldsSearch>, t: Throwable) {
                if (view != null) {
                    view.hideProgress()
                }
            }

        })
    }

}

