package com.example.vkwall.ul

import android.app.Application

import com.example.vkwall.data.DataManager
import com.vk.api.sdk.VK


class App : Application() {

    var dataManager: DataManager? = null

    override fun onCreate() {
        super.onCreate()
        VK.initialize(this)
        dataManager = DataManager()

    }
}
