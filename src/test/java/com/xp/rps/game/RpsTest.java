package com.xp.rps.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.xp.rps.game.Result.*;
import static com.xp.rps.game.Throw.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RpsTest {
    private RoundRepositoryDummy roundRepoDummy;

    // S > P > R > S

    @BeforeEach
    void setUp() {
        roundRepoDummy = new RoundRepositoryDummy();
    }

    @Test
    void scissorsVsPaper() {
        assertEquals(P1_WINS, RPS.play(SCISSORS, PAPER, roundRepoDummy));
    }

    @Test
    void rockVsPaper() {
        assertEquals(P2_WINS, RPS.play(ROCK, PAPER, roundRepoDummy));
    }

    @Test
    void rockVsScissors() {
        assertEquals(P1_WINS, RPS.play(ROCK, SCISSORS, roundRepoDummy));
    }

    @Test
    void scissorsVsRock() {
        assertEquals(P2_WINS, RPS.play(SCISSORS, ROCK, roundRepoDummy));
    }

    @Test
    void paperVsScissors() {
        assertEquals(P2_WINS, RPS.play(PAPER, SCISSORS, roundRepoDummy));
    }

    @Test
    void paperVsRock() {
        assertEquals(P1_WINS, RPS.play(PAPER, ROCK, roundRepoDummy));
    }

    @Test
    void rockVsRock() {
        assertEquals(DRAW, RPS.play(ROCK, ROCK, roundRepoDummy));
    }

    @Test
    void paperVsPaper() {
        assertEquals(DRAW, RPS.play(PAPER, PAPER, roundRepoDummy));
    }

    @Test
    void scissorsVsScissors() {
        assertEquals(DRAW, RPS.play(SCISSORS, SCISSORS, roundRepoDummy));
    }

    @Test
    void callsIncrementOnRepo() {
        // arrange
        RoundRepositorySpy repoSpy = new RoundRepositorySpy();

        // act
        RPS.play(ROCK, SCISSORS, repoSpy);

        // assert
        assertTrue(repoSpy.incrementWasCalled);
    }
}
