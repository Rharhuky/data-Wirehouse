package com.datawareHouse.model.cassandra;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table
public class Venda {

    @PrimaryKey("id_venda")
    private UUID idVenda;

    private String produto;

    private String cidade;
}
