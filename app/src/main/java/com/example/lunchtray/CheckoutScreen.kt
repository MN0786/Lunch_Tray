package com.example.lunchtray

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lunchtray.data.DataSource
import com.example.lunchtray.data.OrderUIState
import com.example.lunchtray.model.MenuItem

@Composable
fun CheckoutScreen(
    orderUIState : OrderUIState,
    onNextButtonClicked : () ->Unit ,
    onCancelButtonClicked : ()->Unit,
    modifier : Modifier = Modifier
) {

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier

    ) {

        Text(
            stringResource(R.string.order_summary),
            fontWeight = FontWeight.Bold
        )
        ItemSummary(
            item = orderUIState.entree,
            modifier = Modifier.fillMaxWidth()
        )
        ItemSummary(
            item = orderUIState.sideDish,
            modifier = Modifier.fillMaxWidth()
        )
        ItemSummary(
            item = orderUIState.accompaniment,
            modifier = Modifier.fillMaxWidth()
        )
        HorizontalDivider(
            thickness = 4.dp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        OrderCost(
            resourceId = R.string.subtotal,
            price = orderUIState.itemTotalPrice.formatPrice(),
            modifier = Modifier.align(Alignment.End)
        )
        OrderCost(
            resourceId = R.string.tax,
            price = orderUIState.orderTax.formatPrice(),
            modifier = Modifier.align(Alignment.End)
        )
        Text(
            text = stringResource(R.string.total, orderUIState.orderTotalPrice.formatPrice()),
            modifier = Modifier.align(Alignment.End),
            fontWeight = FontWeight.Bold

        )

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedButton(
                onCancelButtonClicked,
                modifier  =  Modifier.weight(1f)
            ) {
                Text(stringResource(R.string.cancel_button))
            }
            Button(
                onNextButtonClicked,
                modifier  =  Modifier.weight(1f)
            ) {
                Text(stringResource(R.string.submit))
            }
        }

    }
}
@Composable
fun ItemSummary(
    item : MenuItem?,
    modifier : Modifier = Modifier
){

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ){

        Text(item?.name ?: "")
        Text(item?.getFormattedPrice() ?:"")


    }


}
@Composable
fun OrderCost(
    @StringRes resourceId :  Int,
    price : String,
    modifier : Modifier = Modifier

){

    Text(

    stringResource(resourceId , price),
        modifier  = modifier
    )
}

@Preview
@Composable
fun ItemSummaryScreenPreview(){
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
    modifier = Modifier
        .padding(12.dp)
        .verticalScroll(rememberScrollState())
    ,

)


}