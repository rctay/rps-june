package com.xp.rps.game;

public class GameObserverSpy implements GameObserver {
    boolean roundPlayedWasCalled = false;

    @Override
    public void roundPlayed() {
        roundPlayedWasCalled = true;
    }
}
