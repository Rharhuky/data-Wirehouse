package com.datawareHouse.model.postgres;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "venda")
public class VendaDataWare {

    @Id
    @UuidGenerator
    private UUID idVenda;

    private LocalDateTime horario = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    private ProdutoDataWare produto;

    @ManyToOne
    @JoinColumn(name = "id_cidade", referencedColumnName = "id_cidade")
    private CidadeDataWare cidade;
}
