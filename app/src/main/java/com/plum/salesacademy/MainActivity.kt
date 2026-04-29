package com.plum.salesacademy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.plum.salesacademy.ui.navigation.PlumNavHost
import com.plum.salesacademy.ui.theme.PlumTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlumTheme { PlumNavHost() }
        }
    }
}
