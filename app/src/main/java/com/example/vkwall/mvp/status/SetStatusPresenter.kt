package com.example.vkwall.mvp.status

import com.example.vkwall.data.DataManager
import com.example.vkwall.data.model.Profile.ProfileStatus.FieldsSetStatus
import com.example.vkwall.mvp.base.BasePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SetStatusPresenter : BasePresenter<SetStatusView> {

    private var dataManager: DataManager? = null

    constructor(dataManager: DataManager) {
        this.dataManager = dataManager
    }

    private lateinit var callSetStatus: Call<FieldsSetStatus>

    fun status(text: String, access_token: String, v: String) {
        if (view != null) {
            callSetStatus = dataManager!!.setStatusProfile(text, access_token, v)
            callSetStatus.enqueue(object : Callback<FieldsSetStatus> {
                override fun onResponse(call: Call<FieldsSetStatus>, response: Response<FieldsSetStatus>) {
                    if (view != null) {
                        if (response.isSuccessful) {
                            view.setStatus(response.body())
                        }
                    }
                }

                override fun onFailure(call: Call<FieldsSetStatus>, t: Throwable) {
                    if (view != null) {

                    }
                }
            })
        }
    }
}
