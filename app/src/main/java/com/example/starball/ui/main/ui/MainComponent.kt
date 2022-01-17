package com.example.starball.ui.main.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.starball.R

/**
 * Created on : 1/5/2022
 * Author     : Meysam Mahmoudi
 */
@Preview
@Composable
fun Match() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
    {
        Text(text = "Match",color = Color.Black)
    }

}

@Preview
@Composable
fun Table() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
    {
        Text(text = "Table",color = Color.Black)

    }

}
