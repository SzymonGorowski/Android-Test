package com.example.testapp.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FactContent(
    image: Painter,
    text: String,
    headerModifier: Modifier = Modifier,
    fontSize: TextUnit = 30.sp
) {
    Column {
        CustomImage(image = image)
        Spacer(modifier = Modifier.size(30.dp))
        Header(text = text, modifier = headerModifier, fontSize = fontSize)
    }
}