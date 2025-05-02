package com.example.composecinema.presentation.navigation_graph

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
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.composecinema.presentation.screens.auth_screens.log_In_screen.loginDestination
import com.example.composecinema.presentation.screens.auth_screens.sign_up_screen.signUpDestination
import com.example.composecinema.presentation.screens.core_screens.favorites_screen.favoritesScreenDestination
import com.example.composecinema.presentation.screens.core_screens.home_screen.homePageDestination
import com.example.composecinema.presentation.screens.core_screens.profile_screen.profileScreenDestination
import com.example.composecinema.presentation.screens.core_screens.search_screen.searchScreenDestination
import com.example.composecinema.presentation.screens.welcome_screen.welcomeDestination


@Composable
fun RootNavigationGraph(navController: NavHostController) {

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
            onLoginClick = {
                navController.navigate(NavDest.Login)
            },
            onSignUpClick = {
                navController.navigate(NavDest.SignUp)
            }
        )

        signUpDestination(
            onBackClick = {
                navController.popBackStack()
            },
            onSignUpSuccess = {
                navController.navigate(NavDest.Home) {
                    popUpTo(NavDest.SignUp) { inclusive = true }
                }
            }
        )

        loginDestination(
            onBackClick = {
                navController.popBackStack()
            },
            onLogInSuccess = {
                navController.navigate(NavDest.Home) {
                    popUpTo(NavDest.Login) { inclusive = true }
                }
            }
        )


        // Core tabs
        homePageDestination(
            modifier = Modifier,
            navigateOnSearchScreen = { navController.navigate(NavDest.Search) },
            navController = navController
        )

        searchScreenDestination(
            navController = navController
        )

        favoritesScreenDestination(
            navController = navController
        )

        profileScreenDestination(
            navController = navController
        )

    }
}
