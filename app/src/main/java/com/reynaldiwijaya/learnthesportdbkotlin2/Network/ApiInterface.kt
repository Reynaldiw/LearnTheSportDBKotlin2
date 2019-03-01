package com.reynaldiwijaya.learnthesportdbkotlin2.Network

import com.reynaldiwijaya.learnthesportdbkotlin2.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiInterface {

    fun create() : ApiClient {

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()

        return retrofit.create(ApiClient::class.java)
    }
}