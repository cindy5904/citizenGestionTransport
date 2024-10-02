package org.example.server.repository;

import org.example.server.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {

    List<Station> findByTransportLinesId(Long transportLineId);

}
