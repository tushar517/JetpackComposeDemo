package com.example.jetpackdemo

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

@Composable
fun CustomTextField(txtHint:String, onvalueChange:(String)->Unit, value:String){
    TextField(
        value = value,
        onValueChange = onvalueChange,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(30)),
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        placeholder = { Text(text = txtHint) }
    )
}