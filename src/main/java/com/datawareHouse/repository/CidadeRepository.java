package com.datawareHouse.repository;

import com.datawareHouse.model.cassandra.Cidade;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CidadeRepository extends CassandraRepository<Cidade, UUID> {
}
