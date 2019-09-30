package com.example.vkwall.mvp.status

import android.util.Log
import com.example.vkwall.data.DataManager
import com.example.vkwall.data.model.Profile.ProfileStatus.FieldsGetStatus
import com.example.vkwall.mvp.base.BasePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetStatusPresenter : BasePresenter<GetStatusView> {
    private var dataManager: DataManager? = null

    constructor(dataManager: DataManager?) {
        this.dataManager = dataManager
    }

    private var callStatus: Call<FieldsGetStatus>? = null

    fun loadStatusProfile(access_token: String, v: String) {
        if (view != null) {
            callStatus = dataManager!!.getStatusProfile(access_token, v)
            callStatus!!.enqueue(object : Callback<FieldsGetStatus> {
                override fun onResponse(call: Call<FieldsGetStatus>, response: Response<FieldsGetStatus>) {
                    if (view != null) {
                        if (response.isSuccessful) {
                            view.showStatus(response.body()?.responseStatus)
                        }
                    }
                }

                override fun onFailure(call: Call<FieldsGetStatus>, t: Throwable) {
                    Log.e("ERROR", t.message)
                }
            })
        }
    }
}
