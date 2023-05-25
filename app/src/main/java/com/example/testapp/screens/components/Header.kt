package com.example.testapp.screens.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 30.sp,
    lineHeight: TextUnit = 36.sp,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = Color.Black
) {
    Text(
        text = text,
        modifier = modifier.padding(20.dp),
        textAlign = textAlign,
        lineHeight = lineHeight,
        fontSize = fontSize,
        color = color
    )
}

@Preview
@Composable
private fun HeaderPreview() {
    Header(text = "Testing")
}