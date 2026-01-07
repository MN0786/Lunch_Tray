package com.example.lunchtray.model

import android.view.Menu
import java.text.NumberFormat

sealed class MenuItem(
   open val name : String ,
   open val description : String,
   open val price : Double
){
    data class EntreeMenu(
        override val name: String,
       override val description: String,
       override val price: Double
    ): MenuItem(name , description , price)

    data class SideDishMenu(
        override val name: String,
        override val description: String,
        override val price: Double
    ): MenuItem(name , description , price)

    data class Accompaniment(
       override val name: String ,
       override val description: String,
       override val price : Double
    ): MenuItem(name , description , price)

    fun getFormattedPrice():String = NumberFormat.getCurrencyInstance().format(price)
}