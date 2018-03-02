package tictactoe

typealias Position = Pair<Int, Int>

enum class Player {
    X, O
}

enum class State {
    PLAY, DRAW, WIN
}

class Game {

    private var board: Array<Player?> = arrayOfNulls<Player?>(LENGTH)

    var nextPlayer: Player = INITIAL_PLAYER
    private set

    var winner: Player? = null
    private set

    private var state: State = State.PLAY

    fun reset() {
        board = arrayOfNulls<Player?>(LENGTH)
        nextPlayer = INITIAL_PLAYER
        winner = null
        state = State.PLAY
    }

    fun move(player: Player, position: Position) {
        if (state != State.PLAY) throw IllegalArgumentException()
        if (player != nextPlayer) throw IllegalArgumentException()
        if (!position.isValid()) throw IllegalArgumentException()
        val i = position.getIndex()
        val cell = board[i]
        if (cell != null) throw IllegalStateException()
        board[i] = player
        checkWinner()
        state =
            if (winner != null) State.WIN
            else if (board.none { it == null }) State.DRAW
            else State.PLAY
        nextPlayer = if (nextPlayer == Player.X) Player.O else Player.X
    }

    fun isDraw(): Boolean = state == State.DRAW
    fun isFinished(): Boolean = state != State.PLAY

    private fun checkWinner() {
        for (i in BOARD_RANGE) {
            val line = board.filterIndexed { j, _ -> j.toPosition().first == i }
            winner = line.findSamePlayer()
            if (winner != null) return
            val column = board.filterIndexed { j, _ -> j.toPosition().second == i }
            winner = column.findSamePlayer()
            if (winner != null) return
        }
        val diagonal = board.filterIndexed { j, _ -> j.toPosition().first == j.toPosition().second }
        winner = diagonal.findSamePlayer()
        if (winner != null) return
        val antiDiagonal = board.filterIndexed { j, _ -> j.toPosition().first == SIZE - j.toPosition().second - 1 }
        winner = antiDiagonal.findSamePlayer()
    }

    private fun Position.isValid() =
        (this.first in POSITION_RANGE) and (this.second in POSITION_RANGE)
    private fun Position.getIndex() = this.first * SIZE + this.second
    private fun Int.toPosition() = Position(this / SIZE, this % SIZE)
    private fun List<Player?>.findSamePlayer() =
        if (this.isNotEmpty()) this.reduce { acc, player -> if (acc == player) acc else null }
        else null

    companion object {
        private const val SIZE = 3
        private const val LENGTH = SIZE * SIZE
        private val POSITION_RANGE = 0 until SIZE
        private val BOARD_RANGE = 0 until LENGTH
        private val INITIAL_PLAYER = Player.X
    }
}
