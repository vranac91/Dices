package dvranjicic.dices.data

import android.graphics.Color
import android.widget.ImageView

data class Dice (
    // constructor that takes ImageView from Repo and boolean for checking if the dice is tapped (locked from changing)
    val imageView: ImageView,
    var isTapped: Boolean
) {
    companion object {

        // if the dice is not tapped (locked), sets random image source from the repo
        fun roll(dice: Dice) {
            if (!dice.isTapped) dice.imageView.setImageResource(Repo.imageSources.random())
        }

        // if the dice is tapped, restores its original state and changes background to original
        // if the dice is not tapped, taps it and sets a different background to indicate that it is locked
        fun tap(dice: Dice) {
            if (!dice.isTapped) {
                dice.isTapped = true
                dice.imageView.setBackgroundColor(Color.parseColor("#56c8d8"))
            }
            else {
                dice.isTapped = false
                dice.imageView.setBackgroundColor(Color.parseColor("#f7f7f7"))
            }
        }

        // restores the state of the dice to original
        fun restoreState(dice: Dice) {
            dice.isTapped = false
            dice.imageView.setBackgroundColor(Color.parseColor("#f7f7f7"))
        }
    }
}