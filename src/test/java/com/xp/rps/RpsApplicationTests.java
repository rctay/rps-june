package com.xp.rps;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RpsApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void rockVsScissors_returnsPlayer1Wins() {
        // arrange

        // act
        ResponseEntity<String> response = restTemplate.postForEntity(
                "/play",
                new PlayRequest("ROCK", "SCISSORS"),
                String.class);

        // assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Player 1 Wins!", response.getBody());
    }

    @Test
    void scissorsVsRock_returnsPlayer2Wins() {
        // arrange

        // act
        ResponseEntity<String> response = restTemplate.postForEntity("/play",
                new PlayRequest("SCISSORS", "ROCK"),
                String.class);

        // assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Player 2 Wins!", response.getBody());
    }

    @Test
    void rockVsRock_returnsDraw() {
        ResponseEntity<String> response = restTemplate.postForEntity("/play",
                new PlayRequest("ROCK", "ROCK"),
                String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Draw!", response.getBody());
    }
}
