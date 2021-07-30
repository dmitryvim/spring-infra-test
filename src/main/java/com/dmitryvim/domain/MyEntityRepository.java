package com.dmitryvim.domain;

import org.springframework.lang.Nullable;

import java.util.UUID;

public interface MyEntityRepository {

    void add(MyEntity entity);

    @Nullable
    MyEntity get(UUID id);
}
