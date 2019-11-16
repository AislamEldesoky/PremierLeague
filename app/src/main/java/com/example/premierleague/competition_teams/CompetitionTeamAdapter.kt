package com.example.premierleague.competition_teams

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.premierleague.databinding.ListCompetitionTeamsBinding
import com.example.premierleague.network.Team


class CompetitionTeamAdapter(val onClickListener: OnClickListener,val infoClickListener:InfoClickListener) : ListAdapter<Team,CompetitionTeamAdapter.TeamsViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsViewHolder {
        return TeamsViewHolder(ListCompetitionTeamsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        val teams = getItem(position)

        holder.bind(teams)
        holder.web.setOnClickListener{
            onClickListener.onClick(teams.website)
        }
        holder.info.setOnClickListener {
            infoClickListener.onButtonClick(teams)
        }

    }

    companion object DiffCallback : DiffUtil.ItemCallback<Team> (){
        override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean {
            return oldItem.id == newItem.id
        }

    }

    class TeamsViewHolder (private var binding: ListCompetitionTeamsBinding) :
        RecyclerView.ViewHolder(binding.root){
        val web: TextView = binding.website
        val info:Button = binding.info
            fun bind(teams:Team){
                binding.team = teams
                binding.executePendingBindings()
            }
    }

    class OnClickListener(val clickListener : (url:String)-> Unit){
        fun onClick(url:String) = clickListener(url)
    }
    class InfoClickListener(val infoListener : (team:Team)->Unit){
        fun onButtonClick(team:Team) = infoListener(team)
    }
}