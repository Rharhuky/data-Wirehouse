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
@Table(name = "vendas")
public class VendaDataWare {

    @Id
    @UuidGenerator
    private UUID vendaId;

    private LocalDateTime horario = LocalDateTime.now();

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProdutoDataWare> produtos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private CidadeDataWare cidade;
}
