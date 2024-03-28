package com.tejscore.newsapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tejscore.newsapp.R
import com.tejscore.newsapp.utils.BottomNavItem
import com.tejscore.newsapp.utils.Constants

@Composable
fun TopAppBarCustom(title: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.side_menu),
                contentDescription = "menu",
            )

            Text(
                text = title,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif
            )

            Image(
                painter = painterResource(id = R.drawable.user),
                contentDescription = "user"
            )

        }
    }

}

@Composable
fun BottomBar(clicked: () -> Unit, navHostController: NavHostController? = null) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp))
            .background(Color.LightGray),

        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Constants.provideBottomNavigation().forEach { bottomNavItem ->
                BottomNavItem(bottomNavItem, clicked, navHostController!!)
            }
        }
    }
}

@Composable
fun BottomNavItem(
    bottomNavItem: BottomNavItem,
    clicked: () -> Unit,
    navHostController: NavHostController
) {

    val color = if (bottomNavItem.isSelected) {
        Color.Cyan
    } else {
        Color.Black
    }



    val navStackBackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination

    val selected = currentDestination?.hierarchy?.any { it.route == bottomNavItem.rout } == true

    val image = if (selected) {
        bottomNavItem.selectedIcon
    } else {
        bottomNavItem.normalIcon
    }

    val background =
        if (selected) MaterialTheme.colorScheme.primary.copy(alpha = 0.6f) else Color.Transparent

    val contentColor =
        if (selected) Color.White else Color.Black

    Column(
        modifier = Modifier
            .clip(CircleShape)
            .clickable(onClick = {
                navHostController.navigate(bottomNavItem.rout)
                clicked()
            }),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        Box(
            modifier = Modifier
                .width(55.dp)
                .padding(5.dp)
                .clip(CircleShape)
                .background(background)
        ) {
            Image(
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
                    .align(Alignment.Center)
                    .padding(1.dp),
                painter = painterResource(id = image),
                contentDescription = bottomNavItem.title,
                alignment = Alignment.Center,
                colorFilter = ColorFilter.tint(contentColor)

            )
        }

    }
}


@Preview
@Composable
private fun TopAppPre() {
    TopAppBarCustom("News")
}

@Preview
@Composable
private fun BottomPre() {
    BottomBar(clicked = {}, navHostController = rememberNavController())
}