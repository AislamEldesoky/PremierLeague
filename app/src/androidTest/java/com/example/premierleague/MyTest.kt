package com.example.premierleague

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.premierleague.competition_teams.CompetitionTeamFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MyTest{

    @Test
    fun testEventFragment(){
        val scenario = launchFragmentInContainer<CompetitionTeamFragment>()
        scenario.moveToState(Lifecycle.State.CREATED)
    }

}