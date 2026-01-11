package com.example.lunchtray.data

import com.example.lunchtray.model.MenuItem

data class OrderUIState(

    val entree : MenuItem.EntreeMenu? = null,
    val sideDish :  MenuItem.SideDishMenu? = null,
    val accompaniment :  MenuItem.Accompaniment ? = null,
    val itemTotalPrice : Double  = 0.0,
    val orderTax :  Double  = 0.0,
    val orderTotalPrice : Double  = 0.0

)
