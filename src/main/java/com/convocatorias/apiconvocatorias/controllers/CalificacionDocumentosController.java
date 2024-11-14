package com.convocatorias.apiconvocatorias.controllers;

import com.convocatorias.apiconvocatorias.dto.CalificacionDocumentosDTO;
import com.convocatorias.apiconvocatorias.services.CalificacionDocumentosService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CalificacionDocumentosController {

    private static final String ERROR_SERVER_MESSAGE = "Error interno del servidor";
    private static final String NOT_FOUND_MESSAGE = "Calificacion no encontrada con el ID: ";

    private final CalificacionDocumentosService calificacionDocumentosService;

    @GetMapping(value = "calificacion-documentos")
    public ResponseEntity<Object> getAllCalificacionDocumentos() {
        try {
            List<CalificacionDocumentosDTO> calificacionDocumentos = calificacionDocumentosService.getAllCalificacionDocumentos();
            return ResponseEntity.ok(calificacionDocumentos);
        } catch (DataAccessException ex) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }

    @GetMapping(value = "calificacion-documentos/{id}")
    public ResponseEntity<Object> getCalificacionDocumentosById(@PathVariable Long id) {
        try {
            CalificacionDocumentosDTO calificacionDocumentos = calificacionDocumentosService.getCalificacionDocumentosById(id);

            if (calificacionDocumentos == null) {
                return ResponseEntity.status(404).body(NOT_FOUND_MESSAGE + id);
            }

            return ResponseEntity.ok(calificacionDocumentos);
        } catch (DataAccessException err) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }

    @PostMapping(value = "calificacion-documentos")
    public ResponseEntity<Object> createCalificacionDocumentos(@RequestBody CalificacionDocumentosDTO calificacionDocumentosDTO) {
        try {
            CalificacionDocumentosDTO createdCalificacionDocumentos = calificacionDocumentosService.createCalificacionDocumentos(calificacionDocumentosDTO);
            return ResponseEntity.status(201).body(createdCalificacionDocumentos);
        } catch (DataAccessException ex) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }

    @PutMapping(value = "calificacion-documentos/{id}")
    public ResponseEntity<Object> updateCalificacionDocumentos(@PathVariable Long id, @RequestBody CalificacionDocumentosDTO calificacionDocumentosDTO) {
        try {
            if (calificacionDocumentosService.existsById(id)) {
                CalificacionDocumentosDTO updatedCalificacionDocumentos = calificacionDocumentosService.updateCalificacionDocumentos(id, calificacionDocumentosDTO);
                return ResponseEntity.ok(updatedCalificacionDocumentos);
            }
            return ResponseEntity.status(404).body(NOT_FOUND_MESSAGE + id);
        } catch (DataAccessException ex) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }

    @DeleteMapping(value = "calificacion-documentos/{id}")
    public ResponseEntity<Object> deleteCalificacionDocumentos(@PathVariable Long id) {
        try {
            if (calificacionDocumentosService.existsById(id)) {
                calificacionDocumentosService.deleteCalificacionDocumentos(id);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.status(404).body(NOT_FOUND_MESSAGE + id);
        } catch (DataAccessException ex) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }
}
