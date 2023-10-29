package com.datawareHouse.model.cassandra;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table
public class Cidade {

    @PrimaryKey("id_cidade")
    private UUID idCidade;

    @Column
    private String nome;

    @Column
    private String regiao;

}
