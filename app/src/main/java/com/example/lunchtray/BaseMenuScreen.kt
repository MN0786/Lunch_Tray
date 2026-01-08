package com.example.lunchtray

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lunchtray.data.DataSource
import com.example.lunchtray.model.MenuItem

@Composable
fun BaseMenuScreen(
    options : List<MenuItem>,
    modifier : Modifier = Modifier,
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    onSelectChange : (MenuItem)-> Unit
) {
    var selectedValueItem by rememberSaveable { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.SpaceBetween
    ) {


        Column(
            modifier = modifier
        ) {
            options.forEach { item ->
                val onClick = {
                    selectedValueItem = item.name
                    onSelectChange(item)
                }
                MenuItemRow(
                    item = item,
                    selectedValueItem = selectedValueItem,
                    onclick = onClick,
                    modifier = Modifier.selectable(
                        selected = selectedValueItem == item.name,
                        onClick = onClick
                    )
                )
            }


        }
        Column() {
            ScreenButtonGroup(
                selectedValueItem = selectedValueItem,
                onCancelButtonClicked = onCancelButtonClicked,
                onNextButtonClicked = {
                    onNextButtonClicked()
                },
                modifier = Modifier.fillMaxWidth().padding(12.dp)
            )
        }

    }
}
@Composable
fun MenuItemRow(
    selectedValueItem: String,
    item : MenuItem,
    onclick :() -> Unit,
    modifier : Modifier = Modifier

){

        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {


            RadioButton(
                selected = selectedValueItem == item.name,
                onClick = onclick
            )

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {

                Text(

                    text = item.name,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = item.description,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = item.getFormattedPrice(),
                    style = MaterialTheme.typography.bodyMedium
                )
                HorizontalDivider(
                    thickness = 4.dp,
                    modifier = Modifier
                        .padding(bottom = 18.dp)
                )
            }
        }

}



@Composable
fun ScreenButtonGroup(
    selectedValueItem : String,       
    onNextButtonClicked :()->Unit ,
    onCancelButtonClicked : ()->Unit,
    modifier : Modifier = Modifier
){

    Row(
        horizontalArrangement = Arrangement.spacedBy(18.dp),
        modifier = modifier
    ){
        OutlinedButton(
            onClick = onCancelButtonClicked,
            modifier = Modifier.weight(1f)
        ) {
            Text(stringResource(R.string.cancel_button))
        }
        Button(
            onClick = onNextButtonClicked,
            modifier = Modifier.weight(1f),
            enabled = selectedValueItem.isNotEmpty()
        ) {
            Text(stringResource(R.string.next_button))
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ScreenPreview(){


BaseMenuScreen(
    options = DataSource.entreeMenuItem,
    onNextButtonClicked = {},
    onCancelButtonClicked = {},
    onSelectChange = {}
)



}
