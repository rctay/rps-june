package com.xp.rps.play;

import com.xp.rps.game.GameObserver;
import com.xp.rps.game.RPS;
import com.xp.rps.game.Result;
import com.xp.rps.game.Throw;
import com.xp.rps.history.RoundRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayController {
    private final GameObserver gameObserver;

    public PlayController(GameObserver gameObserver) {
        this.gameObserver = gameObserver;
    }

    @PostMapping("/play")
    public String play(@RequestBody PlayRequest request) {
        Throw player1 = Throw.valueOf(request.getPlayer1());
        Throw player2 = Throw.valueOf(request.getPlayer2());

        Result result = RPS.play(player1, player2, gameObserver);

        if (result == Result.P1_WINS) {
            return "Player 1 Wins!";
        } else if (result == Result.P2_WINS) {
            return "Player 2 Wins!";
        } else {
            return "Draw!";
        }
    }
}
