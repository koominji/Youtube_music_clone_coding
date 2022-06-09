package com.kmj.roomdb_prac

import android.provider.ContactsContract
import androidx.room.*

@Dao
interface CoffeeMenuDao {
    @Insert
    fun insert(coffeeMenu: CoffeeMenu)

    @Update
    fun update(coffeeMenu: CoffeeMenu)

    @Delete
    fun delete(coffeeMenu: CoffeeMenu)

    @Query("SELECT * FROM CoffeeTable")
    fun getAll() : List<CoffeeMenu>

}