package org.example.server.controller;

import org.example.server.dto.TransportTypeDtoGet;
import org.example.server.dto.TransportTypeDtoPost;
import org.example.server.service.TransportTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transport-types")
public class TransportTypeController {

    @Autowired
    private TransportTypeService transportTypeService;

    @GetMapping
    public ResponseEntity<List<TransportTypeDtoGet>> getAllTransportTypes() {
        List<TransportTypeDtoGet> transportTypes = transportTypeService.getAllTransportTypes();
        return ResponseEntity.ok(transportTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransportTypeDtoGet> getTransportTypeById(@PathVariable Long id) {
        TransportTypeDtoGet transportType = transportTypeService.getTransportTypeById(id);
        return ResponseEntity.ok(transportType);
    }

    @PostMapping
    public ResponseEntity<TransportTypeDtoGet> createTransportType(@RequestBody TransportTypeDtoPost transportTypeDtoPost) {
        TransportTypeDtoGet createdTransportType = transportTypeService.createTransportType(transportTypeDtoPost);
        return new ResponseEntity<>(createdTransportType, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransportTypeDtoGet> updateTransportType(
            @PathVariable Long id,
            @RequestBody TransportTypeDtoPost transportTypeDtoPost) {
        TransportTypeDtoGet updatedTransportType = transportTypeService.updateTransportType(id, transportTypeDtoPost);
        return ResponseEntity.ok(updatedTransportType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransportType(@PathVariable Long id) {
        transportTypeService.deleteTransportType(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<TransportTypeDtoGet>> findByTypeContaining(@RequestParam String keyword) {
        List<TransportTypeDtoGet> transportTypes = transportTypeService.findByTypeContaining(keyword);
        return ResponseEntity.ok(transportTypes);
    }

    @DeleteMapping("/type")
    public ResponseEntity<Void> deleteByType(@RequestParam String type) {
        transportTypeService.deleteByType(type);
        return ResponseEntity.noContent().build();
    }


}
