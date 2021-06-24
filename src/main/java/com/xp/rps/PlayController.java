package com.xp.rps;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayController {
    @PostMapping("/play")
    public String play(@RequestBody PlayRequest request) {
        Throw player1 = Throw.valueOf(request.getPlayer1());
        Throw player2 = Throw.valueOf(request.getPlayer2());

        Result result = RPS.play(player1, player2);

        if (result == Result.P1_WINS) {
            return "Player 1 Wins!";
        } else if (result == Result.P2_WINS) {
            return "Player 2 Wins!";
        } else {
            return "Draw!";
        }
    }
}
