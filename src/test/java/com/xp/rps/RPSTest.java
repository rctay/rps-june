package com.xp.rps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RPSTest {

    @Test
    void rockVsScissors() {
        assertEquals(Result.P1_WINS, RPS.play(Throw.ROCK, Throw.SCISSORS));
    }
}
