package com.datawareHouse.model.postgres;

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
@Table(name = "cidades")
public class CidadeDataWare {

    @Id
    private UUID idCidade;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Regiao regiao;


    @OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VendaDataWare> vendas = new ArrayList<>();

}
