package com.example.vkwall.ul.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

class AdapterNewsFeed : RecyclerView.Adapter<AdapterNewsFeed.HolderName>() {

    private var array: ArrayList<String>? = null

    private val holderName: HolderName? = null

    fun NameAdapter(array: ArrayList<String>) {
        this.array = array
    }

    inner class HolderName(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {

        }

        override fun onClick(view: View?) {

        }

    }

    override fun onBindViewHolder(holderName: AdapterNewsFeed.HolderName, position: Int) {

    }

    override fun getItemCount(): Int {
        return 0
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): AdapterNewsFeed.HolderName {
        return holderName as HolderName
    }

}