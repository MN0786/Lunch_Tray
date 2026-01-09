package com.example.lunchtray
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lunchtray.data.DataSource
import com.example.lunchtray.model.MenuItem
import com.example.lunchtray.model.MenuItem.EntreeMenu


@Composable
fun EntreeMenuScreen(
    options :List<EntreeMenu>,
    onNextButtonClicked : ()->Unit,
    onCancelButtonClicked  : ()->Unit,
    onSelectChange : (EntreeMenu) -> Unit,
    modifier : Modifier = Modifier

){

     BaseMenuScreen(
        options = options ,
        onNextButtonClicked = onNextButtonClicked ,
        onCancelButtonClicked = onCancelButtonClicked ,
        onSelectChange = onSelectChange as (MenuItem) -> Unit,
        modifier = modifier

    )

}
@Preview(showBackground = true)
@Composable
fun EntreeMenuListPreview() {

    EntreeMenuScreen(
        options = DataSource.entreeMenuItem,
        onSelectChange = {},
        onCancelButtonClicked = {},
        onNextButtonClicked = {},
        modifier = Modifier.fillMaxHeight().verticalScroll(rememberScrollState())
    )
}

