package com.example.vkwall.mvp.usersinfo

import android.app.AlertDialog
import com.example.vkwall.mvp.base.MvpView

interface DeleteWallView : MvpView {
    fun dialog(alertDialog: AlertDialog)
}
