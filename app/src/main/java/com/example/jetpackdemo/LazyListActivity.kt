package com.example.jetpackdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackdemo.ui.theme.ui.theme.JetpackDemoTheme
import kotlinx.coroutines.launch

class LazyListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val mContext = LocalContext.current
    val state = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold (
        scaffoldState = state,
        drawerContent = {
            TextButton(
                onClick = { makeToast(mContext,"Home Clicked") },
            ) {
                Text(text = "Home")
            }
            TextButton(
                onClick = { makeToast(mContext,"Profile Clicked") },
            ) {
                Text(text = "Profile")
            }
            TextButton(
                onClick = { makeToast(mContext,"Settings Clicked") },
            ) {
                Text(text = "Settings")
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Lazy Activty",
                        color = Color.White
                    )
                },
                backgroundColor = Color.Green,
                navigationIcon = {
                    Icon(
                        Icons.Default.Menu,
                        modifier = Modifier.clickable(
                            onClick = {
                                scope.launch {
                                    state.drawerState.open()
                                }
                            }
                        ),
                        contentDescription = "open drawer button"
                    )
                }
            )
        },
        content = {padding->
            LazyColumn(modifier = Modifier.padding(padding)){
                item{
                    Spacer(modifier = Modifier.height(10.dp))
                }
                items(50){index->
                    if (index%2==0){
                        CustomMessageCard(img = R.drawable.img5, name = "Sender Name $index", msg = "message sent", color = Color.Green, mContext = mContext)
                    }else{
                        CustomMessageCard(img = R.drawable.img5, name = "Sender Name $index", msg = "message sent", color = Color.Black, mContext = mContext)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
                item {
                    CustomButton(txtBtn = "TabLayout Activity",TabLayoutActivity::class.java,mContext)
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { makeToast(mContext,"Home Clicked") },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Home")
                }
                Button(
                    onClick = { makeToast(mContext,"Profile Clicked") },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Profile")
                }
                Button(
                    onClick = { makeToast(mContext,"Settings Clicked") },
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Settings")
                }
            }

        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    JetpackDemoTheme {
        Greeting()
    }
}