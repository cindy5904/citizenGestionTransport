package org.example.server.service;


import org.example.server.entity.TransportLine;
import org.example.server.repository.TransportLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class TransportLineService {

    @Autowired
    private TransportLineRepository transportLineRepository;


    // Méthode pour obtenir toutes les lignes de transport
    public List<TransportLine> getAllTransportLines() {
        return transportLineRepository.findAll();
    }

    public TransportLine createTransportLine(TransportLine transportLine) {
        return transportLineRepository.save(transportLine);
    }
    //Permet de récuperer
    public Optional<TransportLine> getTransportLineById(Long id) {
        return transportLineRepository.findByLineId(id);
    }

    public TransportLine updateTransportLine(TransportLine transportLine) {
        Optional<TransportLine> existTransportLine = transportLineRepository.findById(id);
        if (existTransportLine.isPresent()) {
            TransportLine existingTransportLine = existTransportLine.get();
            transportLine.setName(existingTransportLine.getName());
            transportLine.setOrigin(existingTransportLine.getOrigin());
            transportLine.setDestination(existingTransportLine.getDestination());
            transportLine.setNotifications(existingTransportLine.getNotifications());
            transportLine.setSchedules(existingTransportLine.getSchedules());
            return transportLineRepository.save(transportLine);
        } else {
            throw new RuntimeException("Transport Line Not Found with id" + id);

        }
    }

    public void deleteTransportLine(Long id) {
        if (transportLineRepository.existsById(id)){
            transportLineRepository.deleteById(id);
        } else {
            throw new RuntimeException("Transport Line Not Found with id" + id);
        }
    }
}
