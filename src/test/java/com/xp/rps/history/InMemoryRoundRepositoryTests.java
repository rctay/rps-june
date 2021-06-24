package com.xp.rps.history;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InMemoryRoundRepositoryTests {
    @Test
    void getCount_noRoundsPlayed_returns0() {
        InMemoryRoundRepository subject = new InMemoryRoundRepository();

        assertEquals(0, subject.getCount());
    }

    @Test
    void getCount_oneRoundPlayed_returns1() {
        InMemoryRoundRepository subject = new InMemoryRoundRepository();

        subject.roundPlayed();

        assertEquals(1, subject.getCount());
    }
}
