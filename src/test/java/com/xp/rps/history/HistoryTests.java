package com.xp.rps.history;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
}
