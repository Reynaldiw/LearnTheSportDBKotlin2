package com.reynaldiwijaya.learnthesportdbkotlin2.Model

import com.google.gson.annotations.SerializedName

data class ResponseTeam (
    @SerializedName("teams")
    val teams : List<TeamItem>)