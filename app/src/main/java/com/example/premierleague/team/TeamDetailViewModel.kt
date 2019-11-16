package com.example.premierleague.team

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.premierleague.network.PlayersApi
import com.example.premierleague.network.Team
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TeamDetailViewModel (team:Team,app:Application) : AndroidViewModel(app){
    private val _selectedTeam = MutableLiveData<Team>()

     val selectedTeam : LiveData<Team>
    get() = _selectedTeam

    private var viewModelJob = Job()

    // the Coroutine runs using the Main (UI) dispatcher
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

init {
    _selectedTeam.value = team
    getTeamPlayers()
}

    private fun getTeamPlayers() {
        coroutineScope.launch {
            var getPlayersDeferred = PlayersApi.retrofitService.getPlayers(_selectedTeam.value!!.id)
            try{
                val listResult = getPlayersDeferred.await()
                _selectedTeam.value=listResult
                Log.i("MainActivity","here" + listResult.players!!.size)
            }
            catch (e : Exception){
                Log.i("MainActivity",""+e.message)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}