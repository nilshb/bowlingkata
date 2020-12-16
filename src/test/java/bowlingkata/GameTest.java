package bowlingkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static bowlingkata.Game.GAME_FRAMES;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    private Game game;

    @BeforeEach
    void setup() {
        game = new Game();
    }

    @Test
    void tenPairsOf9andMiss() {
        for (int i = 0; i < GAME_FRAMES; i++) {
            game.roll(9);
            game.roll(0);
        }

        assertEquals(90, game.score());
    }

    @Test
    void perfectGame() {
        for (int i = 0; i < GAME_FRAMES; i++) {
            game.roll(10);
        }
        // bonus
        game.roll(10);
        game.roll(10);

        assertEquals(300, game.score());
    }

    @Test
    void tenPairsOf5AndSpare() {
        for (int i = 0; i < GAME_FRAMES; i++) {
            game.roll(5);
            game.roll(5);
        }
        // bonus
        game.roll(5);

        assertEquals(150, game.score());
    }

    @Test
    void partialGame() {
        game.roll(5);
        game.roll(5);
        game.roll(3);

        assertEquals(16, game.score());
    }

}
