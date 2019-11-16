package com.example.premierleague.network

import com.squareup.moshi.Json
import java.io.Serializable
//@Entity(tableName = "PremiereLeagueTeams")
data class Team  (
    @Json(name = "id")
    var id : Int,
    @Json(name = "name")
    val name : String,
    @Json(name="website")
    val website: String,
    @Json(name = "clubColors")
    val clubColor: String,
    @Json(name = "venue")
    val venue : String,
    @Json(name = "squad")
    var players:List<Player>? = null,
    @Json(name = "crestUrl")
    val imgSrcUrl: String?) : Serializable