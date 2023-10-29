package com.datawareHouse.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PostgresExample {

    @Id
    private Long id;

    private String nome;
}
