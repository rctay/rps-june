package com.xp.rps.game;

import com.xp.rps.game.RPS;
import org.junit.jupiter.api.Test;

import static com.xp.rps.game.Result.*;
import static com.xp.rps.game.Throw.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RpsTest {

    // S > P > R > S

    @Test
    void scissorsVsPaper() {
        assertEquals(P1_WINS, RPS.play(SCISSORS, PAPER));
    }

    @Test
    void rockVsPaper() {
        assertEquals(P2_WINS, RPS.play(ROCK, PAPER));
    }

    @Test
    void rockVsScissors() {
        assertEquals(P1_WINS, RPS.play(ROCK, SCISSORS));
    }

    @Test
    void scissorsVsRock() {
        assertEquals(P2_WINS, RPS.play(SCISSORS, ROCK));
    }

    @Test
    void paperVsScissors() {
        assertEquals(P2_WINS, RPS.play(PAPER, SCISSORS));
    }

    @Test
    void paperVsRock() {
        assertEquals(P1_WINS, RPS.play(PAPER, ROCK));
    }

    @Test
    void rockVsRock() {
        assertEquals(DRAW, RPS.play(ROCK, ROCK));
    }

    @Test
    void paperVsPaper() {
        assertEquals(DRAW, RPS.play(PAPER, PAPER));
    }

    @Test
    void scissorsVsScissors() {
        assertEquals(DRAW, RPS.play(SCISSORS, SCISSORS));
    }

    @Test
    void callsIncrementOnRepo() {
        // arrange
        RoundRepositorySpy repoSpy = new RoundRepositorySpy();

        // act
        RPS.playWithRoundRepo(ROCK, SCISSORS, repoSpy);

        // assert
        assertTrue(repoSpy.incrementWasCalled);
    }
}
