package com.example.premierleague.team

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.premierleague.network.Team

class TeamDetailViewModelFactory(
    private val team :Team,
    private val application: Application
): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TeamDetailViewModel::class.java)){
            return TeamDetailViewModel(team,application) as T
        }
        throw IllegalArgumentException("Unknown ViewModelClass")
    }
}