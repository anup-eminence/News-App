package com.tejscore.newsapp.screens

import android.icu.text.CaseMap.Title
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tejscore.newsapp.R
import com.tejscore.newsapp.screens.navigation.BottomAppNavigation
import com.tejscore.newsapp.utils.ShowToast

@Composable
fun HomeScreen(
    appBarTitle : String
) {
   val navController: NavHostController = rememberNavController()

    Scaffold(
       topBar = { TopAppBarCustom(appBarTitle)},
       bottomBar = {
           BottomBar(clicked = {
               println(">>>>>>BBBBBBB")
           },navController)
       }
   ) { innerPadding->
       Column(
           modifier = Modifier
               .padding(innerPadding),
           verticalArrangement = Arrangement.spacedBy(16.dp),
       ) {
           BottomAppNavigation(navController = navController)
       }
   }
}

@Composable
fun HomeContent() {
    Text(text = "Home")
}


@Preview(showSystemUi = true)
@Composable
private fun HomePre() {
    HomeScreen(appBarTitle = "News")
}