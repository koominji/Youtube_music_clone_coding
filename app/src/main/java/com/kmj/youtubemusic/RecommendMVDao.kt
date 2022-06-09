package com.kmj.youtubemusic

import androidx.room.*

@Dao
interface RecommendMVDao {
    @Insert
    fun insert(recommendMV: RecommendMV)

    @Update
    fun update(recommendMV: RecommendMV)

    @Delete
    fun delete(recommendMV: RecommendMV)

    @Query("SELECT * FROM RecommendMV")
    fun getAllMV():List<RecommendMV>
}