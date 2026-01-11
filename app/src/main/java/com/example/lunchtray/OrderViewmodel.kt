package com.example.lunchtray

import androidx.lifecycle.ViewModel
import com.example.lunchtray.data.OrderUIState
import com.example.lunchtray.model.MenuItem
import com.example.lunchtray.model.MenuItem.Accompaniment
import com.example.lunchtray.model.MenuItem.SideDishMenu
import com.example.lunchtray.model.MenuItem.EntreeMenu
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat

class OrderViewmodel: ViewModel() {
    private val taxRate = 0.08
   private val _uiState = MutableStateFlow(OrderUIState())
    val uiState : StateFlow<OrderUIState> = _uiState.asStateFlow()

    fun  updateEntree(
        entree  : EntreeMenu
    ){

        val prerviousEntree = uiState.value.entree
        updateItem(
            entree ,
            prerviousEntree

        )

    }
    fun updateSidedish(
        sideDish : SideDishMenu
    ){
        val previousSideDishMenu = uiState.value.sideDish
        updateItem(
            sideDish ,
            previousSideDishMenu
        )

    }
    fun updateAccompaniment(
        accompaniment :  Accompaniment
    ){
        val previousAccompaniment = uiState.value.accompaniment
        updateItem(
            accompaniment ,
            previousAccompaniment
            )

    }
    fun resetOrder(){

        _uiState.value = OrderUIState()
    }

    private fun updateItem(
        newItem : MenuItem,
        previousItem: MenuItem?
    ){
        _uiState.update {
            currentState ->
            val previousItemPrice = previousItem?.price ?:0.0
            val itemTotalPrice = currentState.itemTotalPrice - previousItemPrice +newItem.price
            val tax = itemTotalPrice * taxRate


            currentState.copy(
                itemTotalPrice = itemTotalPrice,
                orderTax = tax,
                orderTotalPrice = itemTotalPrice + tax,
                entree = if (newItem is EntreeMenu ) newItem else currentState.entree,
                sideDish = if (newItem is SideDishMenu) newItem else currentState.sideDish,
                accompaniment = if(newItem is Accompaniment) newItem else currentState.accompaniment

            )
        }
    }


}
fun Double.formatPrice(): String {
    return NumberFormat.getCurrencyInstance().format(this)
}
