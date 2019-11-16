package com.example.premierleague.database

import androidx.room.TypeConverter
import com.example.premierleague.network.Player
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GithubTypeConverters {

    var gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<Player> {
        if (data == null) {
            return emptyList()
        }

        val listType = object : TypeToken<List<Player>>() {

        }.type

        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<Player>): String {
        return gson.toJson(someObjects)
    }
}