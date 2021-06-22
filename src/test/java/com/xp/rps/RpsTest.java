package com.xp.rps;

import org.junit.jupiter.api.Test;

import static com.xp.rps.Result.P1_WINS;
import static com.xp.rps.Result.P2_WINS;
import static com.xp.rps.Throw.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
