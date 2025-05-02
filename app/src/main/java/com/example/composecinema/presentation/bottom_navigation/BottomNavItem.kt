package com.example.composecinema.presentation.bottom_navigation

import com.example.composecinema.R
import com.example.composecinema.presentation.navigation_graph.NavDest

sealed class BottomNavItem(val route: String, val label: String, val icon: Int) {
    object Home : BottomNavItem("home", "Home", R.drawable.ic_home)
    object Search : BottomNavItem("search", "Search", R.drawable.ic_search)
    object Favorites : BottomNavItem("favorites", "Favorites", R.drawable.ic_favorites)
    object Profile : BottomNavItem("profile", "Profile", R.drawable.ic_profile)

    companion object {
        val items = listOf(Home, Search, Favorites, Profile)
    }

    fun toNavDest(): NavDest = when (this) {
        Home -> NavDest.Home
        Search -> NavDest.Search
        Favorites -> NavDest.Favorite
        Profile -> NavDest.Profile
    }
}
