package org.example.server.service;

import org.example.server.dto.schedule.TransportLineDtoGet;
import org.example.server.dto.schedule.TransportTypeDtoPost;
import org.example.server.entity.TransportType;
import org.example.server.repository.TransportTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
//
    public TransportType createTransportType(TransportTypeDtoPost transportTypeDtoPost) {
        return transportTypeRepository.save(transportTypeDtoPost);
    }

    public TransportType updateTransportType(Long id, TransportTypeDtoPost transportTypeDetails) {
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
