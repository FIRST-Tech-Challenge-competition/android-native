package com.example.freightfrenzy.utility

import com.example.freightfrenzy.screens.high_scores.TeamProperty
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

val BASE_URL = "https://www.partiklezoo.com"

//Create Moshi obj w KotlinJsonAdapterFactory using Moshi builder
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//Convert JSON response to Kotlin objects using Moshi converter
//Make the API coroutine-based, using the help of coroutine adapter => No longer a Call type in Retrofit
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface FrenzyAPIService {
    @GET("freightfrenzy")
    fun getTeams():
        Deferred<List<TeamProperty>>

    @GET("freightfrenzy")
    fun getTeam(
        @Query(value = "action") action: String = "team",
        @Query(value = "id") id: String
    ):
        Deferred<TeamProperty>
}

//TODO: Need to do some coroutine stuff to make querying more efficient
//Create API obj using Retrofit to implement the API service interface above
object FrenzyAPI {
    val frenzyService : FrenzyAPIService by lazy {
        retrofit.create(FrenzyAPIService::class.java)
    }
}