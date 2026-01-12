package com.example.lunchtray

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StartScreen(
    onStartButtonClicked : ()->Unit,
    modifier : Modifier = Modifier
){

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        ){


            Button(
                onClick = onStartButtonClicked
            ){
                Text(
                    text = stringResource(R.string.start),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(0.75f)

                )


            }


}

    }


@Preview
@Composable
fun StartScreenPreview(){
    StartScreen(
        onStartButtonClicked = {}
        )
}
