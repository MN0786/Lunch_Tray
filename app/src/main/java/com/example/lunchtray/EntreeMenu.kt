package com.example.lunchtray

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lunchtray.data.DataSource
import com.example.lunchtray.model.MenuItem


@Composable
fun EntreeMenu(
    modifier : Modifier = Modifier,
    item : MenuItem,
    onClick : ()->Unit

){
    var selectedValue by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(16.dp)
    ){

        Row(
            modifier = modifier
        ){

            RadioButton(
                selected = selectedValue == item.name,
                onClick = onClick
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
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
                    modifier = Modifier.padding(bottom = 16.dp))
            }
        }


    }
}
//@Preview
//@Composable
//fun EntreeMenuListPreview(){
//EntreeMenu(
//
//)
//}
