package com.example.vkwall.mvp.fave

import com.example.vkwall.data.model.Profile.FaveProfile.GroupFave
import com.example.vkwall.data.model.Profile.FaveProfile.ItemFave
import com.example.vkwall.data.model.Profile.FaveProfile.ProfileFave
import com.example.vkwall.mvp.base.MvpPresenter
import com.example.vkwall.mvp.base.MvpView

interface FaveContract : MvpView {
    fun showFaveProfile(itemFave: List<ItemFave>, profileFaves: List<ProfileFave>, groupFaves: List<GroupFave>)

    fun showProgressFave()

    fun hideProgressFave()

    fun noInternetFave()
}
