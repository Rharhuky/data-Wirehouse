package com.datawareHouse.repository;

import com.datawareHouse.model.postgres.CidadeDataWare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CidadeDataWareRepository extends JpaRepository<CidadeDataWare, UUID> {
}
