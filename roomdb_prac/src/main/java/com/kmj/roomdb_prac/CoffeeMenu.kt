package com.kmj.roomdb_prac

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="CoffeeTable")
data class CoffeeMenu(
    var img:Int,
    var name:String,
    var price:String
){
    @PrimaryKey(autoGenerate = true) var id:Int=0
}
