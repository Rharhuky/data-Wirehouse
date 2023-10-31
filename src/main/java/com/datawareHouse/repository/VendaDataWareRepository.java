package com.datawareHouse.repository;

import com.datawareHouse.model.postgres.VendaDataWare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface VendaDataWareRepository extends JpaRepository<VendaDataWare, UUID> {

}
