package com.tejscore.newsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.tejscore.newsapp.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigate: () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(5000)
        println(">>>>>>>>>>>>>>>>....datatat")
        navigate()
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.news_logo),
            contentDescription = "logo"
        )
    }

}

@Preview(showSystemUi = true)
@Composable
private fun Splash() {
    SplashScreen(navigate = {})
}