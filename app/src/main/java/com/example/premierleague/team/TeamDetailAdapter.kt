package com.example.premierleague.team

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.premierleague.databinding.ListTeamPlayersBinding
import com.example.premierleague.network.Player

class TeamDetailAdapter : ListAdapter<Player,TeamDetailAdapter.TeamViewHolder>(DiffCallBack) {
companion object DiffCallBack : DiffUtil.ItemCallback<Player>(){
    override fun areItemsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem===newItem
    }

    override fun areContentsTheSame(oldItem: Player, newItem: Player): Boolean {
        return oldItem.id == newItem.id
    }

}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(ListTeamPlayersBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val players = getItem(position)
        holder.bind(players)
    }

    class TeamViewHolder (private var binding: ListTeamPlayersBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(players: Player){
            binding.player = players
            binding.executePendingBindings()
        }
    }
}