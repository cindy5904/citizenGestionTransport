package org.example.server.service;

import org.example.server.dto.TransportTypeDtoGet;
import org.example.server.dto.TransportTypeDtoPost;
import org.example.server.entity.TransportType;
import org.example.server.repository.TransportTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class TransportTypeService {
    @Autowired
    private TransportTypeRepository transportTypeRepository;

    public List<TransportTypeDtoGet> getAllTransportTypes() {
        List<TransportType> transportTypes = transportTypeRepository.findAll();
        return transportTypes.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public TransportTypeDtoGet getTransportTypeById(Long id) {
        TransportType transportType = transportTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransportType not found for this id :: " + id));
        return convertToDto(transportType);
    }

    public TransportTypeDtoGet createTransportType(TransportTypeDtoPost transportTypeDtoPost) {
        TransportType transportType = new TransportType();
        transportType.setType(transportTypeDtoPost.getType());
        TransportType savedTransportType = transportTypeRepository.save(transportType);
        return convertToDto(savedTransportType);
    }

    public TransportTypeDtoGet updateTransportType(Long id, TransportTypeDtoPost transportTypeDtoPost) {
        TransportType transportType = transportTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransportType not found for this id :: " + id));
        transportType.setType(transportTypeDtoPost.getType());
        TransportType updatedTransportType = transportTypeRepository.save(transportType);
        return convertToDto(updatedTransportType);
    }

    public void deleteTransportType(Long id) {
        if (transportTypeRepository.existsById(id)) {
            transportTypeRepository.deleteById(id);
        } else {
            throw new RuntimeException("TransportType not found for this id :: " + id);
        }
    }

    public Optional<TransportTypeDtoGet> findByType(String type) {
        return transportTypeRepository.findByType(type)
                .map(this::convertToDto);
    }

    public List<TransportTypeDtoGet> findByTypeContaining(String keyword) {
        List<TransportType> transportTypes = transportTypeRepository.findByTypeContainingIgnoreCase(keyword);
        return transportTypes.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public void deleteByType(String type) {
        transportTypeRepository.deleteByType(type);
    }


    private TransportTypeDtoGet convertToDto(TransportType transportType) {
        return new TransportTypeDtoGet(transportType.getId(), transportType.getType());
    }
}
