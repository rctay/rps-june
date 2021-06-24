package com.xp.rps.game;

import com.xp.rps.game.RPS;
import com.xp.rps.history.RoundRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.xp.rps.game.Result.*;
import static com.xp.rps.game.Throw.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RpsTest {
    private RoundRepositoryDouble roundRepoDouble;

    // S > P > R > S

    @BeforeEach
    void setUp() {
        roundRepoDouble = new RoundRepositoryDouble();
    }

    @Test
    void scissorsVsPaper() {
        assertEquals(P1_WINS, RPS.playWithRoundRepo(SCISSORS, PAPER, roundRepoDouble));
    }

    @Test
    void rockVsPaper() {
        assertEquals(P2_WINS, RPS.playWithRoundRepo(ROCK, PAPER, roundRepoDouble));
    }

    @Test
    void rockVsScissors() {
        assertEquals(P1_WINS, RPS.playWithRoundRepo(ROCK, SCISSORS, roundRepoDouble));
    }

    @Test
    void scissorsVsRock() {
        assertEquals(P2_WINS, RPS.playWithRoundRepo(SCISSORS, ROCK, roundRepoDouble));
    }

    @Test
    void paperVsScissors() {
        assertEquals(P2_WINS, RPS.playWithRoundRepo(PAPER, SCISSORS, roundRepoDouble));
    }

    @Test
    void paperVsRock() {
        assertEquals(P1_WINS, RPS.playWithRoundRepo(PAPER, ROCK, roundRepoDouble));
    }

    @Test
    void rockVsRock() {
        assertEquals(DRAW, RPS.playWithRoundRepo(ROCK, ROCK, roundRepoDouble));
    }

    @Test
    void paperVsPaper() {
        assertEquals(DRAW, RPS.playWithRoundRepo(PAPER, PAPER, roundRepoDouble));
    }

    @Test
    void scissorsVsScissors() {
        assertEquals(DRAW, RPS.playWithRoundRepo(SCISSORS, SCISSORS, roundRepoDouble));
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
