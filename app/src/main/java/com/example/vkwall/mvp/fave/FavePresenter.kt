package com.example.vkwall.mvp.fave

import com.example.vkwall.data.DataManager
import com.example.vkwall.data.model.Profile.FaveProfile.FieldsFave
import com.example.vkwall.data.remote.ServicesGenerator
import com.example.vkwall.data.remote.VkApi
import com.example.vkwall.mvp.base.BasePresenter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavePresenter : BasePresenter<FaveContract> {
    private var dataManager: DataManager? = null

    constructor(dataManager: DataManager?) {
        this.dataManager = dataManager
    }

    private lateinit var fieldsFave: Call<FieldsFave>

    fun loadFaveProfile(access_token: String, extended: Int, fields: String, item_type: String, v: String) {
        if (view != null) {
            view.showProgressFave()
            fieldsFave = dataManager!!.getFaveProfile(access_token, extended, fields, item_type, v)
            fieldsFave.enqueue(object : Callback<FieldsFave> {
                override fun onResponse(call: Call<FieldsFave>, response: Response<FieldsFave>) {
                    if (view != null) {
                        view.hideProgressFave()
                        if (response.isSuccessful) {
                            view.showFaveProfile(
                                    response.body()!!.response.items,
                                    response.body()!!.response.profiles,
                                    response.body()!!.response.groups
                            )
                        }
                    }
                }

                override fun onFailure(call: Call<FieldsFave>, t: Throwable) {
                    if (view != null) {
                        view.hideProgressFave()
                        view.noInternetFave()
                    }
                }

            })
        }
    }
}
