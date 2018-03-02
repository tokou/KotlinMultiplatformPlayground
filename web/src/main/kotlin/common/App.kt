package common

import kotlinx.html.div
import tictactoe.Game
import kotlin.browser.*
import kotlinx.html.js.*
import kotlinx.html.dom.*
import kotlinx.html.id

class App {
    val game = Game()
    var state: String = ""
    set(value) {
        document.getElementById("state")!!.innerHTML = value
    }

    init {
        state = "Next player: ${game.nextPlayer}"
        val range: IntRange = Game.Companion.POSITION_RANGE
        document.getElementById("container")!!.append {
            range.forEach { x ->
                div("line") {
                    range.forEach { y ->
                        div("cell") {
                            id = "$x$y"
                            onClickFunction = { _ ->
                                val player = game.nextPlayer
                                if (!game.isFinished()) {
                                    document.getElementById("$x$y")!!.innerHTML = player.toString()
                                    game.move(x to y)
                                    state = "Next player: ${game.nextPlayer}"
                                }
                                if (game.isFinished()) {
                                    state = if (game.isDraw()) "Draw!"
                                    else "Player ${game.winner} won!"
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    App()
}