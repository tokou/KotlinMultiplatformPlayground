package tictactoe

import kotlin.test.*

class GameTest {

    private lateinit var game: Game

    // @BeforeTest
    // Still not defined in Kotlin Native
    // https://github.com/JetBrains/kotlin-native/pull/1388
    fun setUp() {
        game = Game()
    }

    @Test
    fun testGameInitialState() {
        setUp()
        assertNull(game.winner)
        assertFalse(game.isFinished())
        assertFalse(game.isDraw())
        assertEquals(Player.X, game.nextPlayer)
    }

    @Test
    fun testGameWrongPositionThrows() {
        setUp()
        assertFails {
            game.move(-1 to 0)
        }
    }

    @Test
    fun testReset() {
        setUp()
        listOf(0 to 0, 1 to 0, 0 to 1, 1 to 1, 0 to 2).play(game)
        game.reset()
        testGameInitialState()
    }

    @Test
    fun testGameWinLine() {
        setUp()
        // X X X
        // O O -
        // - - -
        listOf(0 to 0, 1 to 0, 0 to 1, 1 to 1, 0 to 2).play(game)
        assertEquals(Player.X, game.winner)
        assertFalse(game.isDraw())
        assertTrue(game.isFinished())
    }

    @Test
    fun testGameWinColumn() {
        setUp()
        // X O -
        // X O -
        // X - -
        listOf(0 to 0, 0 to 1, 1 to 0, 1 to 1, 2 to 0).play(game)
        assertEquals(Player.X, game.winner)
        assertFalse(game.isDraw())
        assertTrue(game.isFinished())
    }

    @Test
    fun testGameWinDiagonal() {
        setUp()
        // X O -
        // - X O
        // - - X
        listOf(0 to 0, 0 to 1, 1 to 1, 1 to 2, 2 to 2).play(game)
        assertEquals(Player.X, game.winner)
        assertFalse(game.isDraw())
        assertTrue(game.isFinished())
    }

    @Test
    fun testGameWinAntiDiagonal() {
        setUp()
        // - O X
        // O X -
        // X - -
        listOf(0 to 2, 0 to 1, 1 to 1, 1 to 0, 2 to 0).play(game)
        assertEquals(Player.X, game.winner)
        assertFalse(game.isDraw())
        assertTrue(game.isFinished())
    }

    @Test
    fun testGameDraw() {
        setUp()
        // X O X
        // X O O
        // O X X
        listOf(0 to 0, 0 to 1, 0 to 2, 1 to 1, 1 to 0, 1 to 2, 2 to 1, 2 to 0, 2 to 2).play(game)
        assertTrue(game.isDraw())
        assertTrue(game.isFinished())
        assertNull(game.winner)
    }

    private fun List<Position>.play(game: Game) = this.forEach { game.move(it) }
}
