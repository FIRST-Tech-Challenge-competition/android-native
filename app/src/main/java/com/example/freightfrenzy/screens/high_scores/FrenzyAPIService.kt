package com.example.freightfrenzy.screens.high_scores

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

val BASE_URL = "https://www.partiklezoo.com"

//Convert JSON response to string
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface FrenzyAPIService {
    @GET("freightfrenzy")
    fun getTeams():
        Call<String>
}

//Create API obj using Retrofit to implement the API service interface above
object FrenzyAPI {
    val frenzyService : FrenzyAPIService by lazy {
        retrofit.create(FrenzyAPIService::class.java)
    }
}