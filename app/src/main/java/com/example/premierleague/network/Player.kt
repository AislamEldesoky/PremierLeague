package com.example.premierleague.network

import com.squareup.moshi.Json

data class Player(

    @Json(name = "id")
    var id : Int,
    @Json(name = "name")
    var name:String,
    @Json(name = "position")
    var position: String?,
    @Json(name = "shirtNumber")
    var shirtNumber: Int?,
    @Json(name = "nationality")
    var nationality : String,
    @Json(name = "role")
    var role : String

)