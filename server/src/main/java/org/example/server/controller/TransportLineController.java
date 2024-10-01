package org.example.server.controller;


import org.example.server.dto.schedule.TransportLineDtoGet;
import org.example.server.dto.schedule.TransportLineDtoPost;
import org.example.server.entity.TransportLine;
import org.example.server.service.TransportLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/transport-lines")
public class TransportLineController {
    @Autowired
    private TransportLineService transportLineService;

    @GetMapping
    public ResponseEntity<List<TransportLine>> getAllTransportLines() {
        List<TransportLine> transportLines = transportLineService.getAllTransportLines();
        return ResponseEntity.ok(transportLines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransportLine> getTransportLineById(@PathVariable Long id) {
        TransportLine transportLine = transportLineService.getTransportLineById(id);
        return ResponseEntity.ok(transportLine);
    }

    @PostMapping
    public ResponseEntity<TransportLineDtoGet> saveTransportLine(@RequestBody TransportLineDtoPost transportLineDtoPost) {
        TransportLineDtoGet createdTransportLine = transportLineService.createTransportLine(transportLineDtoPost);
        return new ResponseEntity<>(createdTransportLine, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransportLine> updateTransportLine(
            @PathVariable Long id,
            @RequestBody TransportLineDtoPost transportLineDtoPost) {
        TransportLine updatedTransportLine = transportLineService.updateTransportLine(id, transportLineDtoPost);
        return ResponseEntity.ok(updatedTransportLine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransportLine(@PathVariable Long id) {
        transportLineService.deleteTransportLineById(id);
        return ResponseEntity.noContent().build();
    }

}
