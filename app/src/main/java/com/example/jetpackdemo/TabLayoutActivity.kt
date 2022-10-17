package com.example.jetpackdemo

import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackdemo.FragmentLayout.HomeScreen
import com.example.jetpackdemo.FragmentLayout.ProfileScreen
import com.example.jetpackdemo.FragmentLayout.SettingScreen
import com.example.jetpackdemo.ui.theme.JetpackDemoTheme

class TabLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting2()
                }
            }
        }
    }
}

@Composable
fun Greeting2() {
    var tabIndex by remember {
        mutableStateOf(0)
    }
    val homeScreen = HomeScreen()
    val profileScreen = ProfileScreen()
    val settingsScreen = SettingScreen()

    val tabTitles = listOf("Home", "Profile", "Settings")
    val tabIcons = listOf<ImageVector>(
        Icons.Default.Home,Icons.Default.Person, Icons.Default.Settings)
        Scaffold(
            content = {padding->
                Column(modifier = Modifier.padding(padding)) {
                    TabRow(
                        selectedTabIndex = tabIndex
                    ) {
                        tabTitles.forEachIndexed { index, title ->
                            Tab(
                                selected = tabIndex == index,
                                onClick = { tabIndex = index },
                                text = {
                                    Row{
                                        Icon(
                                            tabIcons[index],
                                            contentDescription = "tab Icon",
                                            modifier = Modifier.size(20.dp)
                                        )
                                        Spacer(modifier = Modifier.width(5.dp))
                                        Text(text = title)
                                    }
                                }
                            )
                        }
                    }
                    when (tabIndex) {
                        0 -> HomeScreen()
                        1 -> ProfileScreen()
                        2 -> SettingScreen()
                    }
                }
            }
        )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    JetpackDemoTheme {
        Greeting2()
    }
}