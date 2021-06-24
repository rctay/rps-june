package com.xp.rps.history;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryRoundRepository implements RoundRepository {

    private int count = 0;

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void increment() {
        count += 1;
    }
}
