package com.matchingengine.repository;

import com.matchingengine.model.Execution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecutionRepository extends JpaRepository<Execution, Long> {
}
