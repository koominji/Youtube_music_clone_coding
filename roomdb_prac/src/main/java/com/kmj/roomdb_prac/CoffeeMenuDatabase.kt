package com.kmj.roomdb_prac

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CoffeeMenu::class], version = 1)
abstract class CoffeeMenuDatabase : RoomDatabase() {
    abstract fun coffeeMenuDao(): CoffeeMenuDao

    companion object {
        private var instance: CoffeeMenuDatabase? = null

        @Synchronized
        fun getInstance(context: Context): CoffeeMenuDatabase? {
            if (instance == null) {
                synchronized(CoffeeMenuDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CoffeeMenuDatabase::class.java,
                        "coffee-database" // 다른 DB랑 이름 겹치면 안됨
                    ).build()
                }
            }
            return instance
        }
    }
}