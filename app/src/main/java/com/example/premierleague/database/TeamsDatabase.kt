package com.example.premierleague.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

//@Database(entities = [Team::class,TeamsList::class],version = 1,exportSchema = false)
abstract class TeamsDatabase : RoomDatabase(){
    abstract val teamsDatabaseDao : TeamsDatabaseDao

        companion object{
            @Volatile
            private var INSTANCE : TeamsDatabase?=null
            fun getInstance(context : Context) : TeamsDatabase{
                synchronized(this){
                    var instance = INSTANCE
                    if(instance==null){
                        instance= Room.databaseBuilder(context.applicationContext,
                            TeamsDatabase::class.java,
                            "team_history_database").fallbackToDestructiveMigration().build()
                        INSTANCE = instance
                    }
                    return instance
                }
            }
        }
}