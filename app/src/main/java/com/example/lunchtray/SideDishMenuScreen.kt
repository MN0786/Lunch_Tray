package com.example.lunchtray

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lunchtray.data.DataSource
import com.example.lunchtray.model.MenuItem
import com.example.lunchtray.model.MenuItem.SideDishMenu


@Composable
fun SideDishMenuScreen(
    options : List<SideDishMenu>,
    onNextButtonClicked : ()-> Unit,
    onCancelButtonClicked : ()-> Unit,
    onSelectChange : (SideDishMenu)-> Unit,
    modifier  : Modifier = Modifier
){

    BaseMenuScreen(
        options = options ,
        onNextButtonClicked = onNextButtonClicked ,
        onCancelButtonClicked = onCancelButtonClicked ,
        onSelectChange = onSelectChange as (MenuItem) ->Unit,
        modifier = modifier

    )


}
@Preview(showBackground = true)
@Composable
fun SideDishMenuPreview(){
    SideDishMenuScreen(
        options = DataSource.sideDishMenuItem,
        onSelectChange = {},
        onNextButtonClicked = {},
        onCancelButtonClicked = {},
        modifier = Modifier
            .padding(18.dp)
            .verticalScroll(rememberScrollState())
    )
}

