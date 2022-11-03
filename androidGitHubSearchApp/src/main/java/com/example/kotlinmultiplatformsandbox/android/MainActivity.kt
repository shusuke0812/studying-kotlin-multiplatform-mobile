package com.example.kotlinmultiplatformsandbox.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Surface
import com.example.kotlinmultiplatformsandbox.Greeting
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface (
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                val scope = rememberCoroutineScope()
                var text by remember { mutableStateOf("Loading") }
                LaunchedEffect(true) {
                    scope.launch {
                        text = try {
                            Greeting().greeting()
                        } catch (e: Exception) {
                            e.localizedMessage ?: "error"
                        }
                    }
                }
                Text(text = text)
            }
        }
    }
}

/* old
fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()
    }
}*/