package com.tejscore.newsapp.utils

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable

@Composable
fun ShowToast(context : Context ,msg : String){
    Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
}