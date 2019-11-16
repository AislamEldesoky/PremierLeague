package com.example.premierleague.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

private const val BASE_URL = "https://api.football-data.org/v2/competitions/PL/"
private const val TOKEN = "b149030b5e7f4fea856371458c371d1a"
private const val PLAYER_URL = "https://api.football-data.org/v2/"
private const val id : String = ""
private val moshi  = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL).build()
private val playerRetrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(
    moshi)).addCallAdapterFactory(CoroutineCallAdapterFactory()).baseUrl(PLAYER_URL).build()

interface TeamsApiService{
    @Headers("X-Auth-Token:" + TOKEN )
        @GET("teams")
        fun getTeams():Deferred<TeamsList>
    }

interface PlayersApiService{
    @Headers("X-Auth-Token:" + TOKEN )
    @GET("teams/{id}" )
    fun getPlayers(@Path("id")id : Int):Deferred<Team>



}



object TeamsApi{
    val retrofitService : TeamsApiService by lazy {
        retrofit.create(TeamsApiService::class.java)
    }

}
object PlayersApi{
    val retrofitService : PlayersApiService by lazy {
        playerRetrofit.create(PlayersApiService::class.java)
    }
}