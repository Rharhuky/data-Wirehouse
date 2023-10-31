package com.datawareHouse.model.postgres;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "produto")
public class ProdutoDataWare {

    @Id
    @Column(name = "id_produto")
    private UUID idProduto;

    @Column(name = "nome_produto")
    private String nome;

    @Column(name = "preco_produto")
    private Float preco;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VendaDataWare> vendas = new ArrayList<>();

}
