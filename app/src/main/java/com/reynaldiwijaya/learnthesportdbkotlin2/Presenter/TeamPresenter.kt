package com.reynaldiwijaya.learnthesportdbkotlin2.Presenter

import com.reynaldiwijaya.learnthesportdbkotlin2.Model.ResponseTeam
import com.reynaldiwijaya.learnthesportdbkotlin2.Network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamPresenter (model : TeamContract.View) : TeamContract.Presenter {

    var view : TeamContract.View? = null

    init {
        view = model
    }

    override fun getTeam(league: String) {

        view?.showProgress()

        val apiClient = ApiInterface.create()
        apiClient.getTeams(league).enqueue(object : Callback<ResponseTeam> {

            override fun onResponse(call: Call<ResponseTeam>, response: Response<ResponseTeam>) {
                view?.hideProgress()

                if (response.body() != null) {
                    val responseTeam : ResponseTeam? = response.body()

                    if (responseTeam?.teams != null) {
                        view?.showTeamList(responseTeam.teams)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseTeam>, t: Throwable) {
                view?.hideProgress()
                view?.showFailureMessage(t.message.toString())
            }

        })
    }
}