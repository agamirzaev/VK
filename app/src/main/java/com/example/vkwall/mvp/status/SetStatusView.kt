package com.example.vkwall.mvp.status

import com.example.vkwall.data.model.Profile.ProfileStatus.FieldsSetStatus
import com.example.vkwall.mvp.base.MvpView

interface SetStatusView : MvpView {
    fun setStatus(fieldsSetStatus: FieldsSetStatus?)
}
