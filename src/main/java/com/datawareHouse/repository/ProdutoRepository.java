package com.datawareHouse.repository;

import com.datawareHouse.model.cassandra.Produto;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutoRepository extends CassandraRepository<Produto, UUID> {
}
