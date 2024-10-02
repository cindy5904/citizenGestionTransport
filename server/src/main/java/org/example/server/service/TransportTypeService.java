package org.example.server.service;

import org.example.server.entity.TransportType;
import org.example.server.repository.TransportTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class TransportTypeService {
    @Autowired
    private TransportTypeRepository transportTypeRepository;

    public List<TransportType> getAllTransportTypes() {
        return transportTypeRepository.findAll();
    }

    public Optional<TransportType> getTransportTypeById(Long id) {
        return transportTypeRepository.findById(id);
    }

    public TransportType createTransportType(TransportType transportType) {
        return transportTypeRepository.save(transportType);
    }

    public TransportType updateTransportType(Long id, TransportType transportTypeDetails) {
        TransportType transportType = transportTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransportType not found for this id :: " + id));
        transportType.setType(transportTypeDetails.getType());
        return transportTypeRepository.save(transportType);
    }

    public void deleteTransportType(Long id) {
        if (transportTypeRepository.existsById(id)) {
            transportTypeRepository.deleteById(id);
        } else {
            throw new RuntimeException("TransportType not found for this id :: " + id);
        }
    }
}
