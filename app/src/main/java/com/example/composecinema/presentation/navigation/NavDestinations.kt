package com.example.composecinema.presentation.navigation

import kotlinx.serialization.Serializable

/*object NavDestinations {
    const val LOGIN_OR_SIGN_UP = "login_or_sign_up"
    const val LOGIN = "signIn"
    const val SIGNUP = "sign_up"
    const val MAIN = "main_page"
}*/

@Serializable
sealed interface NavDest{

    @Serializable
    data object Welcome : NavDest

    @Serializable
    data object Login : NavDest

    @Serializable
    data object SignUp: NavDest

    @Serializable
    data object Main : NavDest

    @Serializable
    data object Search : NavDest
}