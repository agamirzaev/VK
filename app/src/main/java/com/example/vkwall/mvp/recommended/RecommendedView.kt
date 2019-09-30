package com.example.vkwall.mvp.recommended

import com.example.vkwall.data.model.Recommended.GroupRecommended
import com.example.vkwall.data.model.Recommended.ItemRecommended
import com.example.vkwall.data.model.Recommended.ProfileRecommended
import com.example.vkwall.mvp.base.MvpView

interface RecommendedView : MvpView {
    fun getRecommended(itemRecommended: List<ItemRecommended>,
                       profileRecommended: List<ProfileRecommended>,
                       groupRecommended: List<GroupRecommended>
    )

    fun showProgress()
    fun hideProgress()
    fun noInternet()
}