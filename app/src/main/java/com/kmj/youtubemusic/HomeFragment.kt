package com.kmj.youtubemusic

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kmj.youtubemusic.databinding.ActivityHomeFragmentBinding

class HomeFragment : Fragment(),LookView {
    lateinit var binding : ActivityHomeFragmentBinding
    private var repeatSongs = ArrayList<RepeatSong>()
    private val recommendMVs = arrayListOf<RecommendMV>()
    lateinit var recommendMVsDB: RecommendMVDatabase
    lateinit var likedSongAdapter:HomeLikeRVAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityHomeFragmentBinding.inflate(inflater,container,false)


        // "다시듣기" arrayList
        repeatSongs.apply {
            add(RepeatSong(R.drawable.likedsong1, "Good Together"))
            add(RepeatSong(R.drawable.likedsong3, "라일락"))
            add(RepeatSong(R.drawable.likedsong4, "Summer"))
            add(RepeatSong(R.drawable.likedsong5, "Maniac"))
            add(RepeatSong(R.drawable.likedsong6, "Overdrive"))
            add(RepeatSong(R.drawable.likedsong1, "Good Together"))
            add(RepeatSong(R.drawable.likedsong3, "라일락"))
            add(RepeatSong(R.drawable.likedsong4, "Summer"))

        }


        // "다시듣기" repeatRV와 Adapter 연결
        val repeatRVAdapter = RepeatRVAdapter(repeatSongs)
        binding.homeRepeatRv.adapter = repeatRVAdapter

        val repeatLayoutManager = GridLayoutManager(context,2)
        repeatLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.homeRepeatRv.layoutManager = repeatLayoutManager



        // DB의 추천 뮤직비디오 data를 arrayList에 넣기
        recommendMVsDB = RecommendMVDatabase.getInstance(requireContext())!!
        recommendMVs.addAll(recommendMVsDB.recommendMVDao().getAllMV())
        Log.d("mv_recommend","${recommendMVs}")


        // "추천 뮤직비디오" homeRecommendMVRV와 Adapter 연결
        val recommendMVRVAdapter = RecommendMVRVAdapter(recommendMVs)
        binding.homeRecommendMVRv.adapter = recommendMVRVAdapter

        val recommendMVLayoutManager = LinearLayoutManager(context)
        recommendMVLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.homeRecommendMVRv.layoutManager = recommendMVLayoutManager

        return binding.root


    }
    override fun onStart() {
        super.onStart()
        getSongs()
    }

    private fun initRecyclerView(result: FloChartResult) {
        likedSongAdapter = HomeLikeRVAdapter(requireContext(), result)

        binding.homeLikeRv.adapter = likedSongAdapter

        val mainRVLayoutManager = LinearLayoutManager(context)
        mainRVLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.homeLikeRv.layoutManager = mainRVLayoutManager
    }

    private fun getSongs() {
        val songService = SongService()
        songService.setLookView(this)

        songService.getSongs()

    }
    override fun onGetSongLoading() {
        Toast.makeText(context,"Loading",Toast.LENGTH_SHORT).show()
    }

    override fun onGetSongSuccess(code: Int, result: FloChartResult) {
        Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()
        initRecyclerView(result)
    }

    override fun onGetSongFailure(code: Int, message: String) {
        Toast.makeText(context,"Failure",Toast.LENGTH_SHORT).show()
    }

}