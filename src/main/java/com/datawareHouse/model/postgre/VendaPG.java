package com.datawareHouse.model.postgre;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "venda")
public class VendaPG {

    @Id
    @UuidGenerator
    private UUID idVenda;

    @OneToOne(mappedBy = "idProduto")
    private ProdutoPG produto;

    @OneToOne(mappedBy = "idCidade")
    private CidadePG cidade;
}
