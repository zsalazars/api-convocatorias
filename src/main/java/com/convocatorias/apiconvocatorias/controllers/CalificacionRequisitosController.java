package com.convocatorias.apiconvocatorias.controllers;

import com.convocatorias.apiconvocatorias.dto.CalificacionRequisitosDTO;
import com.convocatorias.apiconvocatorias.services.CalificacionRequisitosService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CalificacionRequisitosController {

    private static final String ERROR_SERVER_MESSAGE = "Error interno del servidor";
    private static final String NOT_FOUND_MESSAGE = "Calificacion no encontrada con el ID: ";

    private final CalificacionRequisitosService calificacionRequisitosService;

    @GetMapping(value = "calificacion-requisitos")
    public ResponseEntity<Object> getAllCalificacionRequisitos() {
        try {
            List<CalificacionRequisitosDTO> calificacionRequisitos = calificacionRequisitosService.getAllCalificacionRequisitos();
            return ResponseEntity.ok(calificacionRequisitos);
        } catch (DataAccessException ex) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }

    @GetMapping(value = "calificacion-requisitos/{id}")
    public ResponseEntity<Object> getCalificacionRequisitosById(@PathVariable Long id) {
        try {
            CalificacionRequisitosDTO calificacionRequisitos = calificacionRequisitosService.getCalificacionRequisitosById(id);

            if (calificacionRequisitos == null) {
                return ResponseEntity.status(404).body(NOT_FOUND_MESSAGE + id);
            }

            return ResponseEntity.ok(calificacionRequisitos);
        } catch (DataAccessException err) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }

    @PostMapping(value = "calificacion-requisitos")
    public ResponseEntity<Object> createCalificacionRequisitos(@RequestBody CalificacionRequisitosDTO calificacionRequisitosDTO) {
        try {
            CalificacionRequisitosDTO createdCalificacionRequisitos = calificacionRequisitosService.createCalificacionRequisitos(calificacionRequisitosDTO);
            return ResponseEntity.status(201).body(createdCalificacionRequisitos);
        } catch (DataAccessException ex) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }

    @PutMapping(value = "calificacion-requisitos/{id}")
    public ResponseEntity<Object> updateCalificacionRequisitos(@PathVariable Long id, @RequestBody CalificacionRequisitosDTO calificacionRequisitosDTO) {
        try {
            if (calificacionRequisitosService.existsById(id)) {
                CalificacionRequisitosDTO updatedCalificacionRequisitos = calificacionRequisitosService.updateCalificacionRequisitos(id, calificacionRequisitosDTO);
                return ResponseEntity.ok(updatedCalificacionRequisitos);
            }
            return ResponseEntity.status(404).body(NOT_FOUND_MESSAGE + id);
        } catch (DataAccessException ex) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }

    @DeleteMapping(value = "calificacion-requisitos/{id}")
    public ResponseEntity<Object> deleteCalificacionRequisitos(@PathVariable Long id) {
        try {
            if (calificacionRequisitosService.existsById(id)) {
                calificacionRequisitosService.deleteCalificacionRequisitos(id);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.status(404).body(NOT_FOUND_MESSAGE + id);
        } catch (DataAccessException ex) {
            return ResponseEntity.status(500).body(ERROR_SERVER_MESSAGE);
        }
    }
}
