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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composecinema.presentation.screens.logInOrSignUpScreen.LogInOrSignUpScreen
import com.example.composecinema.presentation.screens.logInScreen.LogInScreen
import com.example.composecinema.presentation.screens.mainPage.MainPageScreen
import com.example.composecinema.presentation.screens.signUpScreen.SignUpScreen
import com.example.composecinema.presentation.screens.signUpScreen.SignUpViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MovieNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavDestinations.LOGIN_OR_SIGN_UP,
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
        composable(NavDestinations.LOGIN_OR_SIGN_UP) {
            LogInOrSignUpScreen(
                onLoginClick = {
                    navController.navigate(NavDestinations.LOGIN)
                },
                onSignUpClick = {
                    navController.navigate(NavDestinations.SIGNUP)
                }
            )
        }

        composable(NavDestinations.LOGIN) {
            LogInScreen(onBack = { navController.popBackStack() })
        }

        composable(NavDestinations.SIGNUP) {
            val viewModel: SignUpViewModel = koinViewModel()
            val viewState = viewModel.viewState.collectAsStateWithLifecycle().value
            SignUpScreen(
                viewState = viewState,
                onBackPress = { navController.popBackStack() },
                onRegisterUser = { name, email, password ->
                    viewModel.signUpUser(name, email, password)
                },
                onNavigateNext = {
                    navController.navigate(NavDestinations.MAIN)
                }
            )
        }

        composable(NavDestinations.MAIN) {
            MainPageScreen()
        }
    }
}
