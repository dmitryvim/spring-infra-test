package com.dmitryvim.resource;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HeyResponseTest {

    @Test
    public void should_save_name_and_value() {
        // when
        var sut = new HeyResponse("name", 12);

        // then
        assertThat(sut.getName()).isEqualTo("name");
        assertThat(sut.getCount()).isEqualTo(12);
    }
}