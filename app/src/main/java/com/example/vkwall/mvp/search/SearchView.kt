package com.example.vkwall.mvp.search

import com.example.vkwall.data.model.Search.ItemSearch
import com.example.vkwall.data.model.Search.ProfileSearch
import com.example.vkwall.mvp.base.MvpView

interface SearchView : MvpView {
    fun search(item: List<ItemSearch>)
    fun showProgress()
    fun hideProgress()
}
