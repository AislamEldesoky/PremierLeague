package com.example.premierleague.competition_teams

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.premierleague.databinding.FragmentCompetitionBinding

class CompetitionTeamFragment : Fragment() {

    private val viewModel : CompetitionTeamViewModel by lazy {
        ViewModelProviders.of(this).get(CompetitionTeamViewModel::class.java)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
            val binding = FragmentCompetitionBinding.inflate(inflater)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel
//        val application = requireNotNull(this.activity).application
//        val dataSource = TeamsDatabase.getInstance(application).teamsDatabaseDao
//        val viewModelFactory = CompetitionTeamViewModelFactory(dataSource,application)
//        val competitionTeamViewModel = ViewModelProviders.of(this,viewModelFactory)
//            .get(CompetitionTeamViewModel::class.java)
//        val adapter = CompetitionTeamAdapter
        binding.teamsList.adapter = CompetitionTeamAdapter(CompetitionTeamAdapter.OnClickListener{
            val url = it
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        },CompetitionTeamAdapter.InfoClickListener{
                viewModel.displayTeamDetails(it)
        }

        )
        binding.teamsList.setHasFixedSize(true)

        viewModel.navigateToteamDetail.observe(this, Observer {
            if(null!=it){
                this.findNavController()
                    .navigate(CompetitionTeamFragmentDirections.actionCompetitionTeamFragmentToTeamDetailFragment(it))
                viewModel.displayTeamDetailsComplete()
            }
        })
//        val manager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
//        binding.teamsList.layoutManager = manager
//        competitionTeamViewModel.teams.observe(viewLifecycleOwner, Observer {
//            it?.let {
//                bindRecyclerView(binding.teamsList,it)
//            }
//        })

        return binding.root

    }
}