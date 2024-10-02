package org.example.server.service;


import jakarta.persistence.EntityNotFoundException;
import org.example.server.dto.schedule.TransportLineDtoGet;
import org.example.server.dto.schedule.TransportLineDtoPost;
import org.example.server.entity.TransportLine;
import org.example.server.repository.TransportLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportLineService {

    @Autowired
    private TransportLineRepository transportLineRepository;

    public List<TransportLine> getAllTransportLines() {
        return transportLineRepository.findAll();
    }

    public TransportLine getTransportLineById(Long id) {
        return transportLineRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("TransportLine not found"));
    }

    public TransportLine saveTransportLine(TransportLine transportLine) {
        return transportLineRepository.save(transportLine);
    }

     // Méthode pour mettre à jour une ligne de transport existante
    public TransportLine updateTransportLine(Long id, TransportLineDtoPost transportLineDetails) {
        Optional<TransportLine> existingTransportLine = transportLineRepository.findById(id);

        if (existingTransportLine.isPresent()) {
            TransportLine transportLine = existingTransportLine.get();
            transportLine.setName(transportLineDetails.getName());
            transportLine.setDestination(transportLineDetails.getDestination());
            transportLine.setOrigin(transportLineDetails.getOrigin());
            transportLine.setNotifications(transportLineDetails.getNotifications());
            transportLine.setSchedules(transportLineDetails.getSchedules());
            return transportLineRepository.save(transportLine);
        } else {
            throw new RuntimeException("TransportLine with id " + id + " not found");
        }
    }
    public void deleteTransportLineById(Long id) {
        if (transportLineRepository.existsById(id)){
            transportLineRepository.deleteById(id);
        } else {
            throw new RuntimeException("TransportLine with id " + id + " not found");
        }
    }

}
