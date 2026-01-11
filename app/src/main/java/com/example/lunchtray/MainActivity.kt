package com.example.lunchtray

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lunchtray.data.DataSource
import com.example.lunchtray.data.OrderUIState
import com.example.lunchtray.ui.theme.LunchTrayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LunchTrayTheme {

                CheckoutScreen(
                    orderUIState = OrderUIState(
                        entree = DataSource.entreeMenuItem[0],
                        sideDish = DataSource.sideDishMenuItem[0],
                        accompaniment = DataSource.accompanimentMenuItem[0],
                        itemTotalPrice = 12.0,
                        orderTax = 2.0,
                        orderTotalPrice = 14.0
                    ),
                    onNextButtonClicked = {},
                    onCancelButtonClicked = {},

                )
//                EntreeMenuScreen(
//                    options = DataSource.entreeMenuItem,
//                    onCancelButtonClicked = {},
//                    onNextButtonClicked = {},
//                    onSelectChange = {}
//                )
                }
            }
        }
    }

