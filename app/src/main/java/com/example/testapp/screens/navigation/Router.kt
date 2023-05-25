package com.example.testapp.screens.navigation

import com.example.testapp.R

enum class Router {
    WELCOME, MAIN, CAT_FACT, DOG_FACT
}

sealed class Screen(val titleID: Int, val route: Router) {
    object Welcome: Screen(R.string.welcome_screen_title, Router.WELCOME)
    object Main: Screen(R.string.main_screen_title, Router.MAIN)
    object CatFact: Screen(R.string.cat_fact_screen_title, Router.CAT_FACT)
    object DogFact: Screen(R.string.dog_fact_screen_title, Router.DOG_FACT)

    companion object {
        fun fromRoute(route: String?): Screen {
            return when (route) {
                Router.WELCOME.name-> Welcome
                Router.MAIN.name -> Main
                Router.CAT_FACT.name-> CatFact
                Router.DOG_FACT.name -> DogFact
                else -> Welcome
            }
        }
    }
}