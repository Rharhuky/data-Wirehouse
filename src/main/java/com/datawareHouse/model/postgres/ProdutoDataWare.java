package com.datawareHouse.model.postgres;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "produtos")
public class ProdutoDataWare {

    @Id
    private UUID idProduto;

    @Column(name = "nome_produto")
    private String nome;

    @Column(name = "preco_produto")
    private Float preco;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    private VendaDataWare venda;


}
