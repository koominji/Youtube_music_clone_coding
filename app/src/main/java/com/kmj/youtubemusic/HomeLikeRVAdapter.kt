package com.kmj.youtubemusic

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kmj.youtubemusic.databinding.HomeLikeRvItemBinding

class HomeLikeRVAdapter(val context: Context, val result : FloChartResult)  :
    RecyclerView.Adapter<HomeLikeRVAdapter.ViewHolder>() {

    override fun getItemCount(): Int =result.songs.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): HomeLikeRVAdapter.ViewHolder {
        val binding : HomeLikeRvItemBinding = HomeLikeRvItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if(result.songs[position].coverImgUrl == "" || result.songs[position].coverImgUrl == null){

        } else {
            Log.d("image",result.songs[position].coverImgUrl )
            Glide.with(context).load(result.songs[position].coverImgUrl).into(holder.img)
        }
        holder.title.text = result.songs[position].title
        holder.singer.text=result.songs[position].singer

    }


    inner class ViewHolder(val binding: HomeLikeRvItemBinding) : RecyclerView.ViewHolder(binding.root){

        val img:ImageView=binding.musicCover
        val title :TextView=binding.musicSongTitle
        val singer :TextView=binding.musicSongSinger
    }
}