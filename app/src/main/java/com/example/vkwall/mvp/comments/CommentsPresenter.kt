package com.example.vkwall.mvp.comments

import android.util.Log
import com.example.vkwall.data.DataManager
import com.example.vkwall.data.model.ProfileWall.Comments.Fields
import com.example.vkwall.mvp.base.BasePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsPresenter : BasePresenter<CommentsView> {

    private var dataManager: DataManager

    private lateinit var callField: Call<Fields>

    constructor(dataManager: DataManager) {
        this.dataManager = dataManager
    }

    fun loadCommentsWall(owner_id: String, post_id: String, extended: Int, count: Int, access_token: String, v: String) {
        if (view != null) {
            callField = dataManager.getCommentsWall(owner_id, post_id, extended, count, access_token, v)
            callField.enqueue(object : Callback<Fields> {
                override fun onResponse(call: Call<Fields>, response: Response<Fields>) {
                    if (view != null) {
                        if (response.isSuccessful) {
                            ViewComments(response)
                        }
                    }
                }

                override fun onFailure(call: Call<Fields>, t: Throwable) {
                    if (view != null) {
                        Log.e("ERROR", t.message)
                    }
                }
            })
        }
    }

    private fun ViewComments(response: Response<Fields>) {
        view.showComments(
                response.body()!!.response!!.items!!,
                response.body()!!.response!!.profiles!!,
                response.body()!!.response!!.groups!!
        )
    }
}