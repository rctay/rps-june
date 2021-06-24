package com.xp.rps;

import static com.xp.rps.Result.*;
import static com.xp.rps.Throw.*;

public class RPS {
    public static Result play(Throw player1, Throw player2) {
        if (player1 == player2) {
            return DRAW;
        }

        if (player1 == PAPER    && player2 == SCISSORS ||
            player1 == SCISSORS && player2 == ROCK ||
            player1 == ROCK     && player2 == PAPER
        ) return P2_WINS;

        return P1_WINS;
    }
}
