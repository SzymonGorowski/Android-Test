package com.example.testapp.screens.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomTextButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 25.sp,
    color: Color = Color.Blue
) {
    TextButton(
        onClick = onClick,
        modifier = modifier.padding(20.dp)
    ) {
        Text(
            text = title,
            fontSize =  fontSize,
            color = color
        )
    }
}