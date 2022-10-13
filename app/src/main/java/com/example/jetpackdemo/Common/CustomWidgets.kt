package com.example.jetpackdemo

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomTextField(txtHint:String, onValueChange:(String)->Unit, value:String,icon:ImageVector){
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(30)),
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        placeholder = { Text(text = txtHint) },
        label = { Text(text = txtHint)},
        leadingIcon = {Icon(icon,"PlaceHolder icon")}
    )
}

@Composable
fun CustomButton(txtBtn: String, nextActivity:Class<*>, mContext: Context){
    Button(
        onClick = { startNewActivity(context = mContext,nextActivity) },
        modifier = Modifier
            .clip(RoundedCornerShape(30))
            .fillMaxWidth(),
    ) {
        Text(
            text = txtBtn,
            color = Color.Green,
            style = TextStyle(fontSize = 30.sp)
        )
    }
}


@Composable
fun CustomButtonWithSendValue(txtBtn: String, nextActivity:Class<*>, mContext: Context, value:String){
    Button(
        onClick = { startNewActivityWithValue(context = mContext,nextActivity,value) },
        modifier = Modifier
            .clip(RoundedCornerShape(30))
            .fillMaxWidth(),
    ) {
        Text(
            text = txtBtn,
            color = Color.Green,
            style = TextStyle(fontSize = 30.sp)
        )
    }
}

@Composable
fun CustomMessageCard(img:Int,name:String,msg:String,color: Color,mContext: Context){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                Toast
                    .makeText(
                        mContext, "message $msg Clicked",
                        Toast.LENGTH_LONG
                    )
                    .show()
            }
    ) {
        Card(
            shape = CircleShape,
            modifier = Modifier.size(80.dp)
        ) {
            Image(
                painterResource(id = img),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.width(20.dp))
        Column() {
            Text(text = name, style = TextStyle(color = color, fontWeight = FontWeight.Medium, fontSize = 24.sp))
            Text(text = msg, style = TextStyle(color = color, fontWeight = FontWeight.Normal, fontSize = 20.sp))
        }
    }
}

fun startNewActivity(context: Context, nextActivity:Class<*>){
    context.startActivity(Intent(context,nextActivity))
}

fun startNewActivityWithValue(context: Context, nextActivity:Class<*>, msg:String){
    val intent = Intent(context,nextActivity)
    intent.putExtra("Email",msg)
    context.startActivity(intent)

}

fun makeToast(context: Context,msg:String){
    Toast.makeText(context,"$msg",Toast.LENGTH_LONG).show()
}