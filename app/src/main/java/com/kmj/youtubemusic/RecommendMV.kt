package com.kmj.youtubemusic

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RecommendMV(
    var mvImg:Int,
    var mvTitle:String,
    var mvSinger:String
){
    @PrimaryKey(autoGenerate = true) var id:Int=0
}
