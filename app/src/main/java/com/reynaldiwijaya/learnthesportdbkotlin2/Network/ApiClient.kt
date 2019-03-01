package com.reynaldiwijaya.learnthesportdbkotlin2.Network

import com.reynaldiwijaya.learnthesportdbkotlin2.Model.ResponseTeam
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("api/v1/json/1/search_all_teams.php")
    fun getTeams(@Query("l") league : String) : Call<ResponseTeam>

}