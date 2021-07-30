package com.dmitryvim.resource;

import com.dmitryvim.domain.MyEntity;
import com.dmitryvim.domain.MyEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class MyEntityResource {

    @Autowired
    private final MyEntityRepository entityRepository;

    @GetMapping(value = "/ent/{id}")
    public ResponseEntity<MyEntityData> getData(@PathVariable("id") UUID id) {
        var entity = entityRepository.get(id);
        return ResponseEntity.of(Optional.ofNullable(entity)
                .map(e -> MyEntityData.builder()
                .id(e.getId())
                .name(e.getName())
                .value(e.getValue())
                .build()));
    }

    @PostMapping("/ent")
    public void add(@RequestBody MyEntityData data) {
        var entity = entityRepository.get(data.getId());
        if (entity != null) {
            throw new IllegalArgumentException("Already exists");
        }
        entityRepository.add(MyEntity.builder()
                .id(data.getId())
                .version(0)
                .name(data.getName())
                .value(data.getValue())
                .build());
    }
}
