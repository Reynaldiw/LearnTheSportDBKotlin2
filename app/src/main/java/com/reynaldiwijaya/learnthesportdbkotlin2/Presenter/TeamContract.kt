package com.reynaldiwijaya.learnthesportdbkotlin2.Presenter

import com.reynaldiwijaya.learnthesportdbkotlin2.Model.TeamItem

interface TeamContract {
    interface View {
        fun showProgress()
        fun hideProgress()
        fun showTeamList(teams : List<TeamItem>)
        fun showFailureMessage(error : String)
    }
    interface Presenter {
        fun getTeam(league : String)
    }
}