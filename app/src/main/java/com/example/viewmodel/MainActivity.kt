package com.example.viewmodel

import androidx.lifecycle.viewmodel.compose.viewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.viewmodel.ui.theme.ViewModelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ViewModelTheme {
                MyComponent()
            }
        }
    }
}

@Composable
fun MyComponent(myViewModel: MyViewModel = viewModel()){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
    ) {
            Button(
                modifier = Modifier.padding(all = 16.dp).fillMaxWidth(),
                onClick = {
                    myViewModel.increment()
                }
            ) {
                Text(text = "count ${myViewModel.count}")
            }
        }
    }
}