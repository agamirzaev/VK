package com.example.vkwall.mvp.comments

import com.example.vkwall.data.model.ProfileWall.Comments.Groups
import com.example.vkwall.data.model.ProfileWall.Comments.Item
import com.example.vkwall.data.model.ProfileWall.Comments.Profile
import com.example.vkwall.mvp.base.MvpView

interface CommentsView : MvpView {
    fun showComments(item: List<Item>, profile: List<Profile>, groups: List<Groups>)
}