package com.dmitryvim.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "my_entity")
public class MyEntity {

    @NonNull
    @Id
    private UUID id;

    @NonNull
    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private int value;

}
