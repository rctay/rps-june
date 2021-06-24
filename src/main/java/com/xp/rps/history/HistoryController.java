package com.xp.rps.history;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoryController {

    private final RoundRepository repo;

    public HistoryController(RoundRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/count")
    public int getCount() {
        return repo.getCount();
    }
}
