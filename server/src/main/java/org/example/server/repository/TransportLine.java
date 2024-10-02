package org.example.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportLine extends JpaRepository<TransportLine, Long> {
}
