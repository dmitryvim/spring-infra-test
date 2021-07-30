package com.dmitryvim.persistense;

import com.dmitryvim.domain.MyEntity;
import com.dmitryvim.domain.MyEntityRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.UUID;

@Component
public class InMemoryMyEntityRepository implements MyEntityRepository {

    private final HashMap<UUID, MyEntity> map = new HashMap<>();

    @Override
    public void add(MyEntity entity) {
        map.put(entity.getId(), entity);
    }

    @Override
    public MyEntity get(UUID id) {
        return map.get(id);
    }
}
