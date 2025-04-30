package com.example.composecinema.presentation.navigation

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.composecinema.presentation.screens.auth_screens.welcome_screen.welcomeDestination
import com.example.composecinema.presentation.screens.auth_screens.log_In_screen.loginDestination
import com.example.composecinema.presentation.screens.core_screens.search_screen.searchScreenDestination
import com.example.composecinema.presentation.screens.auth_screens.sign_up_screen.signUpDestination
import com.example.composecinema.presentation.screens.core_screens.home_screen.homePageDestination

@Composable
fun MovieNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavDest.Welcome,
        enterTransition = {
            slideInVertically(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                ),
                initialOffsetY = { fullHeight -> fullHeight }
            ) + fadeIn(animationSpec = tween(400)) + scaleIn(
                initialScale = 0.95f,
                animationSpec = tween(400)
            )
        },
        exitTransition = {
            slideOutVertically(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                ),
                targetOffsetY = { fullHeight -> -fullHeight }
            ) + fadeOut(animationSpec = tween(300)) + scaleOut(
                targetScale = 1.05f,
                animationSpec = tween(300)
            )
        },
        popEnterTransition = {
            slideInVertically(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow
                ),
                initialOffsetY = { fullHeight -> -fullHeight }
            ) + fadeIn(animationSpec = tween(400)) + scaleIn(
                initialScale = 0.9f,
                animationSpec = tween(400)
            )
        },
        popExitTransition = {
            slideOutVertically(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioHighBouncy,
                    stiffness = Spring.StiffnessMedium
                ),
                targetOffsetY = { fullHeight -> fullHeight }
            ) + fadeOut(animationSpec = tween(300)) + scaleOut(
                targetScale = 1.1f,
                animationSpec = tween(300)
            )
        }
    ) {

        welcomeDestination(
            onLoginClick = { navController.navigate(NavDest.Login) },
            onSignUpClick = { navController.navigate(NavDest.SignUp) }
        )

        loginDestination(
            onBackClick = { navController.navigateUp() },
            onLogInSuccess = { navController.navigate(NavDest.Main) }
        )

        signUpDestination(
            onBackClick = { navController.popBackStack() },
            onSignUpSuccess = { navController.navigate(NavDest.Main) }
        )

        // BoottonNavigatiids()

        homePageDestination(
            navigateOnSearchScreen = {
                navController.navigate(NavDest.Search)
            }
            // navigateOnSearchScreen = {navController.navigate(NavDest.Search)}
        )

        searchScreenDestination()

    }
}
