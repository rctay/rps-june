package com.xp.rps.history;

import com.xp.rps.game.GameObserver;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryRoundRepository implements RoundRepository, GameObserver {

    private int count = 0;

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void roundPlayed() {
        count += 1;
    }
}
