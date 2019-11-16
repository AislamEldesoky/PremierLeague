package com.example.premierleague

import android.app.Activity
import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ahmadrosid.svgloader.SvgLoader
import com.example.premierleague.competition_teams.CompetitionTeamAdapter
import com.example.premierleague.network.Player
import com.example.premierleague.network.TeamsList
import com.example.premierleague.team.TeamDetailAdapter
import com.google.firebase.database.FirebaseDatabase


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView : RecyclerView, data: TeamsList?){
    val adapter = recyclerView.adapter as CompetitionTeamAdapter
    if (data != null) {
        adapter.submitList(data.teams)
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)

    }
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = Uri.parse(imgUrl)
        //val activity = imgView.context
        SvgLoader.pluck().with(imgView.context as Activity?).setPlaceHolder(R.mipmap.ic_launcher,R.mipmap.ic_launcher).load(imgUri,imgView)
//        val requestBuilder : RequestBuilder<PictureDrawable> = Glide.with(imgView.context)
//            .`as`(PictureDrawable::class.java)
//            .listener(SvgSoftwareLayerSetter())
////            .load(imgUri)
////            .into(imgView)
//        requestBuilder.load(imgUri).into(imgView)
   }
}

@BindingAdapter("listPlayers")
fun bindRecyclerView(recyclerView : RecyclerView, data: List<Player>?){
    val adapter = recyclerView.adapter as TeamDetailAdapter
    if (data != null) {
        adapter.submitList(data)
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }

}
//@BindingAdapter("loadImage"){
//    fun bind(img : ImageView,url:String){
//        val imgUri = url.toUri().buildUpon().scheme("http").build()
//        Util.fet
//    }
//}