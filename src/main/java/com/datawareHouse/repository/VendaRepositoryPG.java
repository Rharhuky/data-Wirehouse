package com.datawareHouse.repository;

import com.datawareHouse.model.postgre.VendaPG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VendaRepositoryPG extends JpaRepository<VendaPG, UUID> {
}
