package dvranjicic.dices.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dvranjicic.dices.R
import dvranjicic.dices.data.Dice
import dvranjicic.dices.data.Repo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // no need to have base activity since it it only one in the app
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showDices()
        setListeners()
    }

    // generates random dices on the screen on app start
    private fun showDices() {
        addDicesToRepo()
        rollDices()
    }

    // sets on-tap listeners to dices and buttons
    private fun setListeners() {
        for (dice in Repo.dices) dice.imageView.setOnClickListener { Dice.tap(dice) }
        rollDiceButton.setOnClickListener { rollDices() }
        resetButton.setOnClickListener { resetState() }
    }

    // performs roll of each dice
    private fun rollDices() {
        for (dice in Repo.dices) Dice.roll(dice)
    }

    // creates 6 instances of Dice class and adds them to the Repo list variable
    private fun addDicesToRepo() {
        Repo.dices.add(Dice(firstDice, false))
        Repo.dices.add(Dice(secondDice, false))
        Repo.dices.add(Dice(thirdDice, false))
        Repo.dices.add(Dice(fourthDice, false))
        Repo.dices.add(Dice(fifthDice, false))
        Repo.dices.add(Dice(sixthDice, false))
    }

    // iterates through all visible dices and restores their states (removes lock)
    private fun resetState() {
        for (dice in Repo.dices) Dice.restoreState(dice)
    }
}