package com.dmitryvim.resource;

import com.dmitryvim.domain.MyEntity;
import com.dmitryvim.domain.MyEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class MyEntityResource {

    @Autowired
    private final MyEntityRepository entityRepository;

    @GetMapping(value = "/ent/{id}")
    public ResponseEntity<MyEntityData> getData(@PathVariable("id") UUID id) {
        var entity = entityRepository.findById(id)
                .map(e -> MyEntityData.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .value(e.getValue())
                        .build());
        return ResponseEntity.of(entity);
    }

    @PostMapping("/ent")
    @Transactional
    public void add(@RequestBody MyEntityData data) {
        entityRepository.findById(data.getId()).ifPresentOrElse(
                __ -> {
                    throw new IllegalArgumentException("Already exists");
                },
                () -> entityRepository.save(MyEntity.builder()
                        .id(data.getId())
//                .version(0)
                        .name(data.getName())
                        .value(data.getValue())
                        .build()));
    }
}
