package com.datawareHouse.repository;

import com.datawareHouse.model.ProdutoDataWare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutoDataWareRepository extends JpaRepository<ProdutoDataWare, UUID> {
}
