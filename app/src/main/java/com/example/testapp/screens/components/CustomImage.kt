package com.example.testapp.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomImage(
    image: Painter,
    modifier: Modifier = Modifier,
    padding: Dp = 20.dp,
    contentScale: ContentScale = ContentScale.FillWidth
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .padding(padding)
            .fillMaxWidth(),
        contentScale = contentScale
    )
}