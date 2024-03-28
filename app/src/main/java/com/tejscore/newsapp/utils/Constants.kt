package com.tejscore.newsapp.utils

import com.tejscore.newsapp.R
import com.tejscore.newsapp.screens.navigation.NavigationItem


object Constants {

    annotation class URl {
        companion object {
            const val EVERYTHING = "everything"
        }
    }

    fun provideBottomNavigation(): List<BottomNavItem> {
        return listOf(
            BottomNavItem(
                title = "Home",
                rout = NavigationItem.Home.rout,
                selectedIcon = R.drawable.home_selected,
                normalIcon = R.drawable.home_normal,
                isSelected = true
            ),
            BottomNavItem(
                title = "Search",
                rout = NavigationItem.SEARCH.rout,
                selectedIcon = R.drawable.search_selected,
                normalIcon = R.drawable.search_normal,
                isSelected = false
            ),
            BottomNavItem(
                title = "Favorite",
                rout = NavigationItem.BOOKMARKED.rout,
                selectedIcon = R.drawable.bookmark_selected,
                normalIcon = R.drawable.bookmark_normal,
                isSelected = false
            ),

            BottomNavItem(
                title = "Setting",
                rout = NavigationItem.SETTINGS.rout,
                selectedIcon = R.drawable.setting_selected,
                normalIcon = R.drawable.setting_normal,
                isSelected = false
            ),
        )
    }
}

data class BottomNavItem(
    val title: String,
    val rout: String,
    val selectedIcon: Int,
    val normalIcon: Int,
    var isSelected: Boolean
)

enum class BottomNavRout {
    HOME,
    SEARCH,
    FAVORITE,
    SETTING,
}


