package com.dmitryvim.resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class MyEntityResourceTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void should_add_and_get_entity() {
        // given
        var id = UUID.randomUUID();
        var name = "somna";
        var value = 42;
        var request = MyEntityData.builder()
                .id(id)
                .name(name)
                .value(value)
                .build();

        // when
        var post = restTemplate.postForEntity("/ent", request, Object.class);

        // then
        assertThat(post.getStatusCode()).isEqualTo(HttpStatus.OK);

        // when
        var response = restTemplate.getForEntity("/ent/" + id, MyEntityData.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        var body = response.getBody();
        assertThat(body.getId()).isEqualTo(id);
        assertThat(body.getName()).isEqualTo(name);
        assertThat(body.getValue()).isEqualTo(value);
    }

}