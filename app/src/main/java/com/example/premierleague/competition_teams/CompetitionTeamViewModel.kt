package com.example.premierleague.competition_teams

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.premierleague.network.Team
import com.example.premierleague.network.TeamsApi
import com.example.premierleague.network.TeamsList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CompetitionTeamViewModel : ViewModel(){

    private val _competitionTeams = MutableLiveData<TeamsList>()

    val competitionTeam : LiveData<TeamsList>
    get() = _competitionTeams

    private val _navigetToteamDetail = MutableLiveData<Team>()
    val navigateToteamDetail : LiveData<Team>
    get() = _navigetToteamDetail

    private var viewModelJob = Job()

    // the Coroutine runs using the Main (UI) dispatcher
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)
//    val teams = database.getAllTeams()

    init {
        getCompetitionTeams()
    }

    private fun getCompetitionTeams() {
        coroutineScope.launch {
            var getTeamsDeferred = TeamsApi.retrofitService.getTeams()
            try {
                val listResult = getTeamsDeferred.await()
                _competitionTeams.value = listResult
                Log.i("MainActivity","here" + listResult.teams!!.size)

            }catch (e:Exception){

                Log.i("MainActivity",""+e.message)

            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
    fun displayTeamDetails(team:Team){
        _navigetToteamDetail.value = team
    }

    fun displayTeamDetailsComplete(){
        _navigetToteamDetail.value = null
    }
}