package org.example.server.repository;

import org.example.server.entity.TransportLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransportLineRepository extends JpaRepository<TransportLine, Long> {

    List<TransportLine> findByTransportTypeId(Long transportTypeId);

    List<TransportLine> findByOriginAndDestination(String origin, String destination);

}
