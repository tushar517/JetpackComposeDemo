package com.example.jetpackdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackdemo.ui.theme.JetpackDemoTheme

class BoxLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val value:String = intent.getStringExtra("Email").toString()
        setContent {
            JetpackDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BoxLayout(value)
                }
            }
        }
    }
}

@Composable
fun BoxLayout(value:String) {
    val mContext = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Welcome $value",
            style = TextStyle(
                color = Color.Green,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 35.sp
            )
        )

        Spacer(modifier = Modifier.height(20.dp))
        Box {
            Image(
                painterResource(id = R.drawable.img5),
                contentDescription = "Image"
            )
            Image(
                painterResource(id = R.drawable.ic_baseline_check_24),
                contentDescription = "Check mark",
                modifier = Modifier.align(Alignment.BottomEnd)
            )
            Text(
                text = "Picture Clicked",
                style = TextStyle(
                    color = Color.Green,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.ExtraBold),
                modifier = Modifier.align(Alignment.BottomCenter
                )
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        CustomButton(
            txtBtn = "Lazy List Layout Activty",
            mContext = mContext,
            nextActivity = LazyListActivity::class.java
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    JetpackDemoTheme {
        BoxLayout("Name")
    }
}