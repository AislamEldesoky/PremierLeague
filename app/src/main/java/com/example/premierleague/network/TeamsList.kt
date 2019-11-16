package com.example.premierleague.network

import androidx.room.Entity
import com.squareup.moshi.Json
data class TeamsList(
    @Json(name = "teams")
    var teams : List<Team>? = null
)