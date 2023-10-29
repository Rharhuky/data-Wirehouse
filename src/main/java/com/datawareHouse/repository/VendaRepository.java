package com.datawareHouse.repository;

import com.datawareHouse.model.cassandra.Venda;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VendaRepository extends CassandraRepository<Venda, UUID> {
}
