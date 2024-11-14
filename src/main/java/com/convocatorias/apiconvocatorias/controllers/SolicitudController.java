package com.convocatorias.apiconvocatorias.controllers;

import com.convocatorias.apiconvocatorias.dto.SolicitudDTO;
import com.convocatorias.apiconvocatorias.services.SolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SolicitudController {

    private static final String ERROR_SERVER_MESSAGE = "Error interno del servidor";
    private static final String NOT_FOUND_MESSAGE = "Solicitud no encontrada con el ID: ";

    private final SolicitudService solicitudService;

    @GetMapping(value = "solicitudes")
    public ResponseEntity<Object> getAllSolicitudes() {
        try {
            List<SolicitudDTO> solicitudes = solicitudService.getAllSolicitudes();
            return ResponseEntity.ok(solicitudes);
        } catch (DataAccessException err) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }

    @GetMapping(value = "solicitudes/{id}")
    public ResponseEntity<Object> getSolicitudById(@PathVariable Long id) {
        try {
            SolicitudDTO solicitud = solicitudService.getSolicitudById(id);

            if (solicitud == null) {
                return ResponseEntity.status(404).body(NOT_FOUND_MESSAGE + id);
            }

            return ResponseEntity.ok(solicitud);
        } catch (DataAccessException err) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }

    @PostMapping(value = "solicitudes")
    public ResponseEntity<Object> createSolicitud(@RequestBody SolicitudDTO solicitudDTO) {
        try {
            SolicitudDTO createdSolicitud = solicitudService.createSolicitud(solicitudDTO);
            return ResponseEntity.status(201).body(createdSolicitud);
        } catch (DataAccessException ex) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }

    @PutMapping(value = "solicitudes/{id}")
    public ResponseEntity<Object> updateSolicitud(@PathVariable Long id, @RequestBody SolicitudDTO solicitudDTO) {
        try {
            if (solicitudService.existsById(id)) {
                SolicitudDTO updatedSolicitud = solicitudService.updateSolicitud(id, solicitudDTO);
                return ResponseEntity.ok(updatedSolicitud);
            }
            return ResponseEntity.status(404).body(NOT_FOUND_MESSAGE + id);
        } catch (DataAccessException ex) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }
}
