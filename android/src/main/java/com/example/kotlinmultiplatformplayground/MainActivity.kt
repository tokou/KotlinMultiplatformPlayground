package com.example.kotlinmultiplatformplayground

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import tictactoe.Game

class MainActivity : AppCompatActivity() {

    private val game = Game()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        state.text = "Next player: ${game.nextPlayer}"
        val range = Game.Companion.POSITION_RANGE
        range.forEach { x ->
            val line = LinearLayout(this)
            line.orientation = LinearLayout.HORIZONTAL
            range.forEach { y ->
                val cell = Button(this)
                cell.setOnClickListener {
                    val player = game.nextPlayer
                    if (!game.isFinished()) {
                        game.move(x to y)
                        cell.text = player.toString()
                        cell.isEnabled = false
                        state.text = "Next player: ${game.nextPlayer}"
                    }
                    if (game.isFinished()) {
                        state.text =
                            if (game.isDraw()) "Draw!"
                            else "Player ${game.winner} won!"
                    }
                }
                line.addView(cell)
            }
            board.addView(line)
        }
    }
}
