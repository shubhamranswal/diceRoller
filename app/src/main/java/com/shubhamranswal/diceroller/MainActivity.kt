package com.shubhamranswal.diceroller

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.diceValue)
        imageView.setImageResource(R.drawable.dice6)

        val rollButton: Button= findViewById(R.id.rollButton)
        rollButton.setOnClickListener {

            showRandomImages()

        }

    }

    private fun rollDice() {


        val dice = Dice(6)
        val diceRoll = dice.roll()

        val diceImage: ImageView = findViewById(R.id.diceValue)

        // Determine which drawable resource ID to use based on the dice roll
        val diceResult = when (diceRoll) {

            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(diceResult)
    }

    private fun showRandomImages() {

        val timer = object: CountDownTimer(1250, 50) {
            override fun onTick(millisUntilFinished: Long) {
                val imageIds = intArrayOf(
                    R.drawable.dice1,
                    R.drawable.dice2,
                    R.drawable.dice3,
                    R.drawable.dice4,
                    R.drawable.dice5,
                    R.drawable.dice6,
                )

                val imageView : ImageView = findViewById(R.id.diceValue)

                imageView.setImageResource(imageIds.random())
            }
            override fun onFinish() {
                rollDice()
            }
        }
        timer.start()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}