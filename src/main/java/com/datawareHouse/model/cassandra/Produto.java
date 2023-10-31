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
public class Produto {

    @PrimaryKey("id_produto")
    private UUID idProduto;

    private String nome;

    private Float preco;

}
