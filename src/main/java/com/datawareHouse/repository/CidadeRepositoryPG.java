package com.datawareHouse.repository;

import com.datawareHouse.model.postgre.CidadePG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CidadeRepositoryPG extends JpaRepository<CidadePG, UUID> {
}
