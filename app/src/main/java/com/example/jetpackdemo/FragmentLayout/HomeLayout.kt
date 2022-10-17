package com.example.jetpackdemo.FragmentLayout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.jetpackdemo.CustomTextField

@Composable
fun HomeScreen(){
    var value by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Home Screen", style = TextStyle(fontWeight = FontWeight.ExtraBold), fontSize = 30.sp)
        CustomTextField(txtHint = "value", onValueChange = {
            value = it
        }, value = value, icon = Icons.Default.Add)
    }
}