package com.example.lunchtray

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lunchtray.data.DataSource
import com.example.lunchtray.data.OrderUIState


@Composable
fun LunchTrayApp(
    viewModel: OrderViewmodel = viewModel(),
    navController : NavHostController = rememberNavController()

){
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = LunchTrayScreen.valueOf(
        backStackEntry?.destination?.route?:LunchTrayScreen.Start.name
    )
    Scaffold(
        topBar = {
            LunchTrayAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry!= null,
                navigateUp = {
                    navController.navigateUp()
                }


                )
        }
    ) {

        innerPadding->

        val uiState by viewModel.uiState.collectAsState()
        NavHost(
            navController = navController,
            startDestination = LunchTrayScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(
                route = LunchTrayScreen.Start.name
            ){
                StartScreen(
                    onStartButtonClicked = {
                        navController.navigate(LunchTrayScreen.Entree.name)
                    },
                    modifier = Modifier.fillMaxSize().padding(16.dp)
                )

            }

            composable(
                route = LunchTrayScreen.Entree.name
            ){
                EntreeMenuScreen(
                options = DataSource.entreeMenuItem,
                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(navController , viewModel)
                    },
                    onSelectChange = {
                        viewModel.updateEntree(it)
                    },
                    onNextButtonClicked = {
                        navController.navigate(LunchTrayScreen.Sidedish.name)
                    }
                )

            }
            composable(LunchTrayScreen.Sidedish.name) {

                SideDishMenuScreen(
                    options = DataSource.sideDishMenuItem,
                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(navController , viewModel)
                    },
                    onSelectChange = {
                        viewModel.updateSidedish(it)
                    },
                    onNextButtonClicked = {
                        navController.navigate(LunchTrayScreen.Accompaniment.name)
                    }
                )
            }
            composable(LunchTrayScreen.Accompaniment.name) {
                AccompanimentMenuScreen(
                    options = DataSource.accompanimentMenuItem,
                    onSelectChange = {
                        viewModel.updateAccompaniment(it)
                    },
                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(navController , viewModel)
                    },
                    onNextButtonClicked = {
                        navController.navigate(LunchTrayScreen.Checkout.name)
                    }
                )

            }
            composable(route = LunchTrayScreen.Checkout.name) {
                CheckoutScreen(
                    onNextButtonClicked = {},
                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(navController , viewModel)
                    },
                    orderUIState = OrderUIState(
                        entree  = uiState.entree,
                        sideDish = uiState.sideDish,
                        accompaniment = uiState.accompaniment,
                        itemTotalPrice = uiState.itemTotalPrice,
                        orderTax = uiState.orderTax,
                        orderTotalPrice = uiState.orderTotalPrice

                    )
                )
            }


        }





    }




}
enum class LunchTrayScreen(
    @StringRes val title : Int,

){
    Start(title = R.string.app_name),
    Entree(title = R.string.choose_entree),
    Sidedish(title = R.string.choose_side_dish),
    Accompaniment(title = R.string.choose_accompaniment),

    Checkout(title = R.string.order_checkout)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LunchTrayAppBar(
    currentScreen : LunchTrayScreen,
    canNavigateBack  : Boolean,
    navigateUp : () -> Unit,
    modifier : Modifier = Modifier
){
    TopAppBar(
        title = {
            Text(stringResource(currentScreen.title))
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier  = modifier,
        navigationIcon = {
            IconButton(
                onClick = navigateUp
            ) {

                if (canNavigateBack){
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null
                    )
                }

            }
        }
    )



}
private fun cancelOrderAndNavigateToStart(
    navController : NavHostController,
    viewmodel: OrderViewmodel
){

    viewmodel.resetOrder()
    navController.popBackStack(LunchTrayScreen.Start.name , inclusive = false)

}
@Preview
@Composable
fun AppBarPreview(){



    LunchTrayApp()

}
