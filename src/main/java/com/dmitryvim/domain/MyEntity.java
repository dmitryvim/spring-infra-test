package com.dmitryvim.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.util.UUID;

@Builder
@EqualsAndHashCode
@Getter
public class MyEntity {

    @NonNull
    private final UUID id;

    @NonNull
    private final int version;

    @NonNull
    private final String name;
    private final int value;

}
