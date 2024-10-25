package com.convocatorias.apiconvocatorias.controllers;

import com.convocatorias.apiconvocatorias.dto.DependenciaDTO;
import com.convocatorias.apiconvocatorias.services.DependenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DependenciaController {

    private static final String ERROR_SERVER_MESSAGE = "Error interno del servidor";
    private static final String NOT_FOUND_MESSAGE = "Dependencia no encontrada con el ID: ";

    private final DependenciaService dependenciaService;

    @GetMapping(value = "dependencias")
    public ResponseEntity<Object> getAllDependencias() {
        try {
            List<DependenciaDTO> dependencia = dependenciaService.getAllDependencias();
            return ResponseEntity.ok(dependencia);
        } catch (DataAccessException ex) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }

    @GetMapping(value = "dependencias/{id}")
    public ResponseEntity<Object> getDependenciaById(@PathVariable Long id) {
        try {
            DependenciaDTO dependencia = dependenciaService.getDependenciaById(id);

            if (dependencia == null) {
                return ResponseEntity.status(404).body(NOT_FOUND_MESSAGE + id);
            }

            return ResponseEntity.ok(dependencia);
        } catch (DataAccessException err) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }

    @PostMapping(value = "dependencias")
    public ResponseEntity<Object> createDependencia(@RequestBody DependenciaDTO dependenciaDTO) {
        try {
            DependenciaDTO createdDependencia = dependenciaService.createDependencia(dependenciaDTO);
            return ResponseEntity.status(201).body(createdDependencia);
        } catch (DataAccessException ex) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }

    @PutMapping(value = "dependencias/{id}")
    public ResponseEntity<Object> updateDependencia(@PathVariable Long id, @RequestBody DependenciaDTO dependenciaDTO) {
        try {
            if (!dependenciaService.existsById(id)) {
                return ResponseEntity.status(404).body(NOT_FOUND_MESSAGE + id);
            }
            DependenciaDTO updatedDependencia = dependenciaService.updateDependencia(id, dependenciaDTO);
            return ResponseEntity.ok(updatedDependencia);
        } catch (DataAccessException ex) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }
}
