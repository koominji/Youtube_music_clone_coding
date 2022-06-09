package com.kmj.youtubemusic

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kmj.youtubemusic.databinding.HomeRepeatRvItemBinding

class RepeatRVAdapter(val repeatSong:ArrayList<RepeatSong>):RecyclerView.Adapter<RepeatRVAdapter.ViewHolder>() {

    override fun getItemCount(): Int = repeatSong.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding:HomeRepeatRvItemBinding= HomeRepeatRvItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = (holder as RepeatRVAdapter.ViewHolder).binding
        holder.bind(repeatSong[position])
        binding.recyclerItemRoot.setOnClickListener {
            Log.d("??", "${position}")
        }
    }



    inner class ViewHolder(val binding:HomeRepeatRvItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(repeatSong: RepeatSong){
            binding.musicCover.setImageResource(repeatSong.img!!) //repeat song img
            binding.musicSongTitle.text=repeatSong.title //repeat song title
        }
    }
}