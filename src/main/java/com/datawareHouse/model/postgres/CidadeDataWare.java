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
@Table(name = "cidade")
public class CidadeDataWare {

    @Id
    @Column(name = "id_cidade")
    private UUID idCidade;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Regiao regiao;

    @OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VendaDataWare> vendas = new ArrayList<>();

}
