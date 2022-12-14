package com.example.jetpackdemo


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackdemo.ui.theme.JetpackDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginUi()
                }
            }
        }
    }
}

@Composable
fun LoginUi() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val mcontext = LocalContext.current
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ){
        Card(
            shape = CircleShape,
            modifier = Modifier.size(150.dp)
        ) {
            Image(
                painterResource(id = R.drawable.img5),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "LOGIN",
            color = Color.Green,
            style = TextStyle(fontSize = 25.sp),
            modifier = Modifier
                .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(20))
                .padding(15.dp)
        )
        Spacer(modifier = Modifier.height(34.dp))
        Column(Modifier.padding(horizontal = 20.dp)){
            CustomTextField(txtHint = "Enter your Email ID", onValueChange = {
                email = it
            }, value = email,
                icon = Icons.Default.Email
            )
            Spacer(modifier = Modifier.height(10.dp))
            CustomTextField(txtHint = "Enter your Password", onValueChange = {
                password = it
            }, value = password,
                icon = Icons.Default.Lock
            )
            Spacer(modifier = Modifier.height(10.dp))
            CustomButtonWithSendValue(
                txtBtn = "Login",
                mContext = mcontext,
                nextActivity = BoxLayoutActivity::class.java,
                value = email,
                enable = validation(email, password)
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp)
        ) {
            TextButton(onClick = { makeToast(mcontext,"$email $password") }) {
                Text("Forgot Password?", style = TextStyle(color = Color.Blue, fontWeight = FontWeight.Medium, fontStyle = FontStyle.Italic, fontSize = 25.sp))
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackDemoTheme {
        LoginUi()
    }
}