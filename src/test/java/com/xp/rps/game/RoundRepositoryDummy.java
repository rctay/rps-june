package com.xp.rps.game;

import com.xp.rps.history.RoundRepository;

public class RoundRepositoryDummy implements RoundRepository {
    @Override
    public int getCount() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void increment() {

    }
}
