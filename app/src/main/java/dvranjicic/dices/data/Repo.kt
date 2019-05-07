package dvranjicic.dices.data

import dvranjicic.dices.R

object Repo {
    // variable for storing dices
    val dices = mutableListOf<Dice>()

    // variable for storing dice image sources
    val imageSources = listOf(
        R.drawable.one,
        R.drawable.two,
        R.drawable.three,
        R.drawable.four,
        R.drawable.five,
        R.drawable.six
    )
}