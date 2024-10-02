package org.example.server.controller;

import org.example.server.dto.schedule.TransportLineDtoGet;
import org.example.server.dto.schedule.TransportLineDtoPost;
import org.example.server.dto.schedule.TransportTypeDtoGet;
import org.example.server.dto.schedule.TransportTypeDtoPost;
import org.example.server.entity.TransportType;
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
    private TransportTypeDtoPost transportTypeDtoPost;
    @GetMapping
    public List<TransportType> getAllTransportTypes() {
        return transportTypeService.getAllTransportTypes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransportLineDtoGet> createTransportType(@RequestBody TransportTypeDtoPost transportTypeDtoPost) {
        TransportType createdTransportLine = transportTypeService.createTransportType(transportTypeDtoPost);
        return new ResponseEntity(createdTransportLine, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransportType> updateTransportType(
            @PathVariable Long id,
            @RequestBody TransportTypeDtoPost transportTypeDtoPost) {
        TransportType updatedTransportType = transportTypeService.updateTransportType(id, transportTypeDtoPost);
        return ResponseEntity.ok(updatedTransportType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransportType(@PathVariable Long id) {
        transportTypeService.deleteTransportType(id);
        return ResponseEntity.noContent().build();
    }


}
