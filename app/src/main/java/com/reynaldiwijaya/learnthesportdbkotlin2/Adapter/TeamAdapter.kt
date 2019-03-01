package com.reynaldiwijaya.learnthesportdbkotlin2.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.reynaldiwijaya.learnthesportdbkotlin2.Model.TeamItem
import com.reynaldiwijaya.learnthesportdbkotlin2.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_team.*

class TeamAdapter (val context : Context, val teams : List<TeamItem>) :
    RecyclerView.Adapter<TeamAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_team, p0, false))
    }

    override fun getItemCount(): Int {
        return teams.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindItems(teams[p1])
    }


    class ViewHolder (override val containerView : View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bindItems (team : TeamItem) {
            tv_teamName.text = team.teamName
            Glide.with(itemView.context)
                .load(team.imageClub)
                .into(img_club)
        }

    }
}