package com.kmj.youtubemusic

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kmj.youtubemusic.databinding.HomeLikeRvItemBinding
import com.kmj.youtubemusic.databinding.HomeRecommendMvRvItemBinding

class RecommendMVRVAdapter(val recommendMV:ArrayList<RecommendMV>) :
    RecyclerView.Adapter<RecommendMVRVAdapter.ViewHolder>() {

    override fun getItemCount(): Int = recommendMV.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecommendMVRVAdapter.ViewHolder {
        val binding : HomeRecommendMvRvItemBinding = HomeRecommendMvRvItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("??", "onBindViewHolder : $position")
        val binding = (holder as RecommendMVRVAdapter.ViewHolder).binding
        holder.bind(recommendMV[position])
        binding.recommendMVItemRoot.setOnClickListener {
            Log.d("??", "${position}")
        }
    }



    inner class ViewHolder(val binding: HomeRecommendMvRvItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(recommendMV: RecommendMV){
            binding.recommendMVItemIv.setImageResource(recommendMV.mvImg!!) //mv image
            binding.recommendMVItemTitleTv.text = recommendMV.mvTitle // title
            binding.recommendMVItemSingerTv.text=recommendMV.mvSinger // singer
        }
    }

}