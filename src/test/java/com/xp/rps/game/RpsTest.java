package com.xp.rps.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.xp.rps.game.Result.*;
import static com.xp.rps.game.Throw.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RpsTest {
    private GameObserverDummy gameObserverDummy;

    // S > P > R > S

    @BeforeEach
    void setUp() {
        gameObserverDummy = new GameObserverDummy();
    }

    @Test
    void scissorsVsPaper() {
        assertEquals(P1_WINS, RPS.play(SCISSORS, PAPER, gameObserverDummy));
    }

    @Test
    void rockVsPaper() {
        assertEquals(P2_WINS, RPS.play(ROCK, PAPER, gameObserverDummy));
    }

    @Test
    void rockVsScissors() {
        assertEquals(P1_WINS, RPS.play(ROCK, SCISSORS, gameObserverDummy));
    }

    @Test
    void scissorsVsRock() {
        assertEquals(P2_WINS, RPS.play(SCISSORS, ROCK, gameObserverDummy));
    }

    @Test
    void paperVsScissors() {
        assertEquals(P2_WINS, RPS.play(PAPER, SCISSORS, gameObserverDummy));
    }

    @Test
    void paperVsRock() {
        assertEquals(P1_WINS, RPS.play(PAPER, ROCK, gameObserverDummy));
    }

    @Test
    void rockVsRock() {
        assertEquals(DRAW, RPS.play(ROCK, ROCK, gameObserverDummy));
    }

    @Test
    void paperVsPaper() {
        assertEquals(DRAW, RPS.play(PAPER, PAPER, gameObserverDummy));
    }

    @Test
    void scissorsVsScissors() {
        assertEquals(DRAW, RPS.play(SCISSORS, SCISSORS, gameObserverDummy));
    }

    @Test
    void callsRoundPlayedOnGameObserver() {
        // arrange
        GameObserverSpy gameObserverSpy = new GameObserverSpy();

        // act
        RPS.play(ROCK, SCISSORS, gameObserverSpy);

        // assert
        assertTrue(gameObserverSpy.roundPlayedWasCalled);
    }
}
