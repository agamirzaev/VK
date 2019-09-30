package com.example.vkwall.mvp.usersinfo

import android.app.AlertDialog
import android.util.Log
import com.example.vkwall.data.DataManager
import com.example.vkwall.data.model.DeleteWall.FieldsDeleteWall
import com.example.vkwall.mvp.base.BasePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DeleteWallPresenter : BasePresenter<DeleteWallView> {
    private var dataManager: DataManager

    constructor(dataManager: DataManager) {
        this.dataManager = dataManager
    }

    private lateinit var callDeleteWall: Call<FieldsDeleteWall>

    fun deleteWall(owner_id: Int, post_id: Int, access_token: String, v: String) {
        callDeleteWall = dataManager.deleteWall(owner_id, post_id, access_token, v)
        callDeleteWall.enqueue(object : Callback<FieldsDeleteWall> {
            override fun onFailure(call: Call<FieldsDeleteWall>, t: Throwable) {
                if (view != null) {
                }
            }

            override fun onResponse(call: Call<FieldsDeleteWall>, response: Response<FieldsDeleteWall>) {
                if (view != null) {
                    if (response.isSuccessful) {
                        Log.e("EWRGWREJNG", call.request().toString())
                    }
                }
            }
        })
    }
}
