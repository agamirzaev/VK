package com.example.vkwall.mvp.recommended

import android.util.Log
import com.example.vkwall.data.DataManager
import com.example.vkwall.data.model.Recommended.FieldsRecommended
import com.example.vkwall.mvp.base.BasePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecommendedPresenter : BasePresenter<RecommendedView> {
    private var dataManager: DataManager? = null
    private lateinit var call: Call<FieldsRecommended>

    constructor(dataManager: DataManager?) {
        this.dataManager = dataManager
    }

    fun loadRecommended(access_token: String, v: String) {
        view.showProgress()
        call = dataManager!!.getRecommended(access_token, v)
        call.enqueue(object : Callback<FieldsRecommended> {
            override fun onFailure(call: Call<FieldsRecommended>, t: Throwable) {
                if (view != null) {
                    view.noInternet()
                    view.hideProgress()
                }
            }

            override fun onResponse(call: Call<FieldsRecommended>, response: Response<FieldsRecommended>) {
                if (view != null) {
                    view.hideProgress()
                    if (response.isSuccessful) {
                        view.getRecommended(
                                response.body()!!.response!!.items!!,
                                response.body()!!.response!!.profiles!!,
                                response.body()!!.response!!.groups!!)
                    }
                }
            }
        })
    }
}