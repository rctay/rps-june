package com.xp.rps.history;

import com.xp.rps.play.PlayRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class HistoryTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void noRoundsPlayed_returns0() {
        // arrange

        // act
        ResponseEntity<Integer> response = restTemplate.getForEntity("/count", Integer.class);

        // assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(0, response.getBody());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void roundWasPlayed_returns1() {
        // arrange / setup
        restTemplate.postForEntity("/play",
                new PlayRequest("ROCK", "SCISSORS"),
                String.class);

        // act
        ResponseEntity<Integer> response = restTemplate.getForEntity("/count", Integer.class);

        // assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody());
    }
}
