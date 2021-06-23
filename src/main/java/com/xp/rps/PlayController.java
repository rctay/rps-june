package com.xp.rps;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayController {
    @PostMapping("/play")
    public String play(@RequestBody PlayRequest request) {
        return "Player 1 Wins!";
    }
}
