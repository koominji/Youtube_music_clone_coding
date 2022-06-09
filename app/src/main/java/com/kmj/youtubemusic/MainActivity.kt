package com.kmj.youtubemusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kmj.youtubemusic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()
        inputDummyMVs()
    }
    private fun initBottomNavigation(){

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, HomeFragment())
            .commitAllowingStateLoss()

        binding.mainBottomTab.setOnItemSelectedListener{ item ->
            when (item.itemId) {

                R.id.homeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.lookFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, LookFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true

                }
                R.id.lockerFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, LockerFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true

                }
            }
            false
        }
    }

    private fun inputDummyMVs(){
        val recommendMVsDB = RecommendMVDatabase.getInstance(this)!!
        val recommendMVs = recommendMVsDB.recommendMVDao().getAllMV()

        if (recommendMVs.isNotEmpty()) return

        recommendMVsDB.recommendMVDao().insert(
            RecommendMV(
                R.drawable.mv_one,
                "[MV] IVE(아이브) _LOVE DIVE",
                "1theK (원더케이) 조회수 197만회 1개월 전"
            )
        )
        recommendMVsDB.recommendMVDao().insert(
            RecommendMV(
                R.drawable.mv_two,
                "(여자)아이들((G)I-DLE) - 'TOMBOY' Official Music Video",
                "(G)I-DLE (여자)아이들 (Official YouTube Channel) 조회수 1.2억 2개월 전"
            )
        )
        recommendMVsDB.recommendMVDao().insert(
            RecommendMV(
                R.drawable.mv_three,
                "PSY - 'Celeb' MV",
                "officialpsy 조회수 1704만회 4주 전"
            )
        )

        Log.d("mv",recommendMVsDB.recommendMVDao().getAllMV().toString())
    }

}