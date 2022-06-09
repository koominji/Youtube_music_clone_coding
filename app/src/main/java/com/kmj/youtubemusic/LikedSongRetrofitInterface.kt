package com.kmj.youtubemusic
import retrofit2.Call
import retrofit2.http.GET


interface LikedSongRetrofitInterface {
    @GET("/songs")
    fun getSongs(): Call<SongResponse>
}