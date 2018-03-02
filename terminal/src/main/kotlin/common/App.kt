package common

import tictactoe.Game
import tictactoe.Player
import tictactoe.Position
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val game = Game()
    val board = mutableMapOf<Position, Player>()

    while (true) {
        printBoard(game, board)
        if (game.isFinished()) exitProcess(0)
        val readLine = readLine()
        val regex = "[0-${Game.SIZE-1}],[0-${Game.SIZE-1}]".toRegex()
        if (readLine == null) {
            exitProcess(0)
        } else if (readLine.matches(regex)) {
            val (a, b) = readLine.split(',').map(String::toInt)
            board[a to b] = game.nextPlayer
            game.move(a to b)
        } else {
            println("Unrecognized cell: '$readLine'. Cell format: '${regex}'")
        }
    }
}

fun printBoard(game: Game, board: MutableMap<Position, Player>) {
    val range = Game.POSITION_RANGE
    range.forEach { x ->
        println(" " + "----".repeat(Game.SIZE))
        print(" | ")
        range.forEach { y ->
            print(board[x to y] ?: "-")
            print(" | ")
        }
        println()
    }
    println(" " + "----".repeat(Game.SIZE))

    if (game.isFinished()) {
        if (game.isDraw()) println("Draw!")
        else println("Player ${game.winner} won!")
    }
    if (!game.isFinished()) {
        println("Next player ${game.nextPlayer}")
        print("Enter cell position: ")
    }
}
