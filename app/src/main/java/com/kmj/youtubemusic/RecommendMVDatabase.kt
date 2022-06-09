package com.kmj.youtubemusic

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RecommendMV::class],version = 1)
abstract class RecommendMVDatabase :RoomDatabase(){
    abstract fun recommendMVDao():RecommendMVDao
    companion object{
        private var instance : RecommendMVDatabase? = null
        @Synchronized
        fun getInstance(context: Context):RecommendMVDatabase?{
            if(instance==null){
                synchronized(RecommendMVDatabase::class){
                    instance= Room.databaseBuilder(
                        context.applicationContext,
                        RecommendMVDatabase::class.java,
                        "recommendMV-database" //다른 데이터 베이스랑 이름 겹치면 꼬인다
                    ).allowMainThreadQueries().build()
                }
            }
            return instance
        }
    }
}