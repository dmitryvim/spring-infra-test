package com.dmitryvim.resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class HeyResponseTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void should_use_default_name() {
        // when
        var response = restTemplate.getForObject("/hey", HeyResponse.class);

        // then
        assertThat(response.getName()).isEqualTo("noname");
    }

    @Test
    public void should_use_name_from_parametres() {
        // when
        var response = restTemplate.getForObject("/hey?name=test", HeyResponse.class);

        // then
        assertThat(response.getName()).isEqualTo("test");
    }
}
