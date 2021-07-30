package com.dmitryvim.resource;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class MyEntityData {

    private final UUID id;
    private final String name;
    private final int value;
}
