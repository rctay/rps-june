package com.xp.rps.game;

import com.xp.rps.history.RoundRepository;

public class RoundRepositorySpy implements RoundRepository {
    boolean incrementWasCalled = false;

    @Override
    public int getCount() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void increment() {
        incrementWasCalled = true;
    }
}
