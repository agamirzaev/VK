package com.example.vkwall.mvp.status

import com.example.vkwall.data.model.Profile.ProfileStatus.ResponseStatus
import com.example.vkwall.mvp.base.MvpView


interface GetStatusView : MvpView {
    fun showStatus(responseStatus: ResponseStatus?)

}
