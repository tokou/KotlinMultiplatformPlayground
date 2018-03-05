package com.example.desktop

import javafx.event.EventHandler
import javafx.scene.control.Label
import javafx.scene.input.MouseEvent
import javafx.scene.layout.Pane
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import tictactoe.Game
import tictactoe.Player
import tictactoe.Position
import tornadofx.*

class MainView : View("Tic Tac Toe") {

    private val rectangles = mutableMapOf<Position, Rectangle>()

    private val game = Game()
    private lateinit var state: Label

    override val root = borderpane {
        setPrefSize(260.0, 280.0)
        center = gridpane {
            for (y in Game.Companion.POSITION_RANGE) {
                row {
                    for (x in Game.Companion.POSITION_RANGE) {
                        makeCell(y, x)
                    }
                }
            }
        }
        state = label("Next player: ${game.nextPlayer}")
        bottom = state
    }

    private fun Pane.makeCell(y: Int, x: Int) {
        rectangle {
            rectangles[y to x] = this
            fill = Color.GRAY
            width = 80.0
            height = 80.0
            gridpaneConstraints {
                marginRight = if (x == Game.Companion.SIZE - 1) 0.0 else 10.0
                marginBottom = if (y == Game.Companion.SIZE - 1) 0.0 else 10.0
            }
            onMouseClicked = EventHandler<MouseEvent> {
                val player = game.nextPlayer
                if (!game.isFinished()) {
                    game.move(x to y)
                    fill = if (player == Player.X) Color.RED else Color.BLUE
                    state.text = "Next player: ${game.nextPlayer}"
                }
                if (game.isFinished()) {
                    state.text =
                        if (game.isDraw()) "Draw!"
                        else "Player ${game.winner} won!"
                }
            }
        }
    }
}
