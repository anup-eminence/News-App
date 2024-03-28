package com.tejscore.newsapp.screens.navigation

enum class Screens {
    ROOT,
    SPLASH,
    HOME,
    BOOKMARKED,
    SETTINGS,
    SEARCH,
    PROFILE
}

sealed class NavigationItem(val rout : String) {
    data object ROOT : NavigationItem(Screens.ROOT.name)
    data object Home : NavigationItem(Screens.HOME.name)
    data object SPLASH : NavigationItem(Screens.SPLASH.name)
    data object BOOKMARKED : NavigationItem(Screens.BOOKMARKED.name)
    data object SETTINGS : NavigationItem(Screens.SETTINGS.name)
    data object SEARCH : NavigationItem(Screens.SEARCH.name)
    data object PROFILE : NavigationItem(Screens.PROFILE.name)
}