package com.datawareHouse.repository;

import com.datawareHouse.domain.PostgresExample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface postgreRepository extends JpaRepository<PostgresExample, Long> {
}
