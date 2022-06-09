package com.kmj.roomdb_prac

import CoffeeMenuRVAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.kmj.roomdb_prac.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var coffeeMenuDB: CoffeeMenuDatabase
    lateinit var binding: ActivityMainBinding
    var coffeeList= ArrayList<CoffeeMenu>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        inputDummyAlbums()





        // home "오늘의 음악" homeTodayAlbumRv Adapter연결
//        val coffeeRVAdapter = CoffeeMenuRVAdapter(coffeeList)
//        binding.mainRv.adapter = coffeeRVAdapter
//
//        val layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
//        binding.mainRv.layoutManager = layoutManager

//        coffeeMenuDB= CoffeeMenuDatabase.getInstance(this)!!
//
//        Thread {
//            val savedContacts = coffeeMenuDB.coffeeMenuDao().getAll()
//            if (savedContacts.isNotEmpty()) {
//                list.addAll(savedContacts)
//            }
//        }.start()


    }

    private fun inputDummyAlbums() {
        val coffeeMenuDB = CoffeeMenuDatabase.getInstance(this)!!
        val coffeeMenus = coffeeMenuDB.coffeeMenuDao().getAll()

        if (coffeeMenus.isNotEmpty()) return

        coffeeMenuDB.coffeeMenuDao().insert(
            CoffeeMenu(
                R.drawable.coffee1,
                "coffee1", "1000"
            )
        )
        coffeeMenuDB.coffeeMenuDao().insert(
            CoffeeMenu(
                R.drawable.coffee1,
                "coffee2", "2000"
            )
        )
        coffeeMenuDB.coffeeMenuDao().insert(
            CoffeeMenu(
                R.drawable.coffee1,
                "coffee3", "3000"
            )
        )
        coffeeMenuDB.coffeeMenuDao().insert(
            CoffeeMenu(
                R.drawable.coffee1,
                "coffee4", "4000"
            )
        )
        Log.d("??",coffeeMenuDB.coffeeMenuDao().getAll().toString())
    }
}