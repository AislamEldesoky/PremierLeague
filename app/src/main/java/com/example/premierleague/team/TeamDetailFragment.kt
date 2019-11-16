package com.example.premierleague.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.premierleague.databinding.FragmentTeamBinding

class TeamDetailFragment: Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        val binding = FragmentTeamBinding.inflate(inflater)
        binding.setLifecycleOwner (this)
        val team = TeamDetailFragmentArgs.fromBundle(arguments!!).selectedTeam
        val viewModelFactory = TeamDetailViewModelFactory(team , application)
        binding.viewModel = ViewModelProviders.of(this,viewModelFactory).get(TeamDetailViewModel::class.java)
        binding.players.adapter = TeamDetailAdapter()

        return binding.root
    }
}