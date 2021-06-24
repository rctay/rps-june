package com.xp.rps.history;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryRoundRepository implements RoundRepository{
    @Override
    public int getCount() {
        return 0;
    }
}
