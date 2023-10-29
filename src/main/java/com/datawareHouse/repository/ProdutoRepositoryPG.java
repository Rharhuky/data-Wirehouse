package com.datawareHouse.repository;

import com.datawareHouse.model.postgre.ProdutoPG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutoRepositoryPG extends JpaRepository<ProdutoPG, UUID> {
}
